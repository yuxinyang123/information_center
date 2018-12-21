package com.hnu.softwarecollege.infocenter.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.hnu.softwarecollege.infocenter.context.ThreadContext.getUserContext;


/**
 * @program: infocenter
 * @description: this is a jwt class,https://jwt.io/,https://github.com/auth0/java-jwt
 * @author: yu
 * @create: 2018-11-08 00:17
 **/
@Component
@Slf4j
//@Configuration
public class TokenUtil {
//    lombok注解替代logger声明
//    Logger logger = LoggerFactory.getLogger(this.getClass());


    //注解不能用在静态变量上！使用静态变量可以使用set方法注入！！！！！！！！！！！


    private static String salt;

    private static long exp;

    private static long remeberTime;

    @Value("${token.salt}")
    public void setSalt(String salt) {
        TokenUtil.salt = salt;
    }

    @Value("${token.expired-time}")
    public void setExp(long exp) {
        TokenUtil.exp = exp;
    }

    @Value("${token.rememberme-time}")
    public void setRemeberTime(long remeberTime) {
        TokenUtil.remeberTime = remeberTime;
    }

    /**
     * iss: jwt签发者
     * sub: jwt所面向的用户
     * aud: 接收jwt的一方
     * exp: jwt的过期时间，这个过期时间必须要大于签发时间
     * nbf: 定义在什么时间之前，该jwt都是不可用的.
     * iat: jwt的签发时间
     * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
    * @Description: HMAC256放盐加密,生成token
    * @Param:
    * @return: java.lang.String
    * @Author: yu
    * @Date: 2018/11/8 0:25
    **/
    public static String createToken(){
        log.info("{},{},{}",salt,exp,remeberTime);
        try {
            Algorithm algorithm = Algorithm.HMAC256(salt);
            Map<String,Object> head = new HashMap<>();
            head.put("alg","none");
            head.put("typ","none");
//            JWT token标准三部分，head，payload，signature

            UserPo contextUser=ThreadContext.getUserContext();
            String token = JWT.create()
                    .withHeader(head)
                    .withClaim("email",contextUser.getUserEmail())
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+exp))
                    .sign(algorithm);
            log.info("token has been created :{}",token);
            return token;
        } catch (UnsupportedEncodingException e) {
            log.error("create token fail,unsupported encoding:{}",salt);
        }
        return null;
    }

    /**
    * @Description: token验证
    * @Param: [java.lang.String]
    * @return: boolean
    * @Author: yu
    * @Date: 2018/11/8 1:11
    **/
    public static boolean VerifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(salt);

            JWTVerifier jwtVerifier = JWT.require(algorithm).build();

            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            String email=decodedJWT.getClaim("email").asString();


            UserPo userPo = new UserPo();

            userPo.setUserEmail(email);

            ThreadContext.setUserContext(userPo);

            log.info("token verify success,email:{}",email);

        } catch (UnsupportedEncodingException e) {

            log.error("verify token fail,unsupported encoding:{}",salt);

            return false;
        }
        return true;
    }



//    /**
//    * @Description: 解密token
//    * @Param: []
//    * @return: java.lang.String
//    * @Author: yu
//    * @Date: 2018/11/8 1:13
//    **/
//    public static String decodeToken(){
//        return null;
//    }
}
