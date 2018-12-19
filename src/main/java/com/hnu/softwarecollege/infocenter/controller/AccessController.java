package com.hnu.softwarecollege.infocenter.controller;


import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.service.UserService;
import com.hnu.softwarecollege.infocenter.util.TokenUtil;
import com.hnu.softwarecollege.infocenter.util.VerifyCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("access")
@Slf4j
public class AccessController {

    @Resource
    UserService userService;


    /**
     * @Description: 生成跨域cookie
     * @Param: [name, value]
     * @return: javax.servlet.http.Cookie
     * @Author: yu
     * @Date: 2018/11/9 2:30
     **/
    private Cookie getCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
//        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }

    /**
     * @param
     * @return
     * @author ying
     * @description //TODO cookieLog工具
     * @date 15:55 2018/12/11
     **/
    private void logAllCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            log.info("name:{} and value:{}", cookie.getName(), cookie.getValue());
        }
    }

    /**
     * @Description: 用户登录 登录生成token，放于cookie中返回，生成上下文用户对象，filter使用该上下文验证用户
     * @Param: [loginForm]
     * @return: com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author: yu
     * @Date: 2018/11/7
     **/
    @PostMapping("user")
    @ResponseBody
    public BaseResponseVo login(
            @RequestBody @Valid LoginForm loginForm,HttpSession session,
            HttpServletResponse response) {
        //will set userContext
        boolean isTrue = userService.verifyUser(loginForm);
        if (isTrue) {
            String token = TokenUtil.createToken();
            response.addCookie(getCookie("token", token));
            response.addCookie(getCookie("id", String.valueOf(ThreadContext.getUserContext().getUserId())));
            return BaseResponseVo.success(token);
        } else {
            return BaseResponseVo.fail("login fail");
        }
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author yuxinyang
     * @Description //TODO 获取验证码
     * @Date 14:55 2018/11/21
     * @Param []
     **/
    @GetMapping(value = "/verifycode")
    public BaseResponseVo getVerifycode(@RequestParam(value = "random", required = false) Double random, HttpServletResponse response
            , HttpSession session) {
        String verifyCode = null;
        try {
            verifyCode = VerifyCodeUtil.outputVerifyImage(response.getOutputStream(), 4);
            session.setAttribute("verifycode", verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResponseVo.success(verifyCode);
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author yuxinyang
     * @Description //TODO 验证验证码
     * @Date 10:13 2018/11/22
     * @Param []
     **/
    @PostMapping("/verifycode")
    public BaseResponseVo createVerifycode(@NotBlank @RequestBody Map<String, Object> map, HttpSession session,
                                           HttpServletRequest request) {
        String verifycode = (String) map.get("verifycode");

        String serverVerifycode = (String) session.getAttribute("verifycode");

//        log.info("client:{} and server:{}", verifycode, serverVerifycode);
        if (verifycode.equalsIgnoreCase(serverVerifycode)) {
            return BaseResponseVo.success("verify success");
        } else {
            return BaseResponseVo.fail("verify fail");
        }
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author yuxinyang
     * @Description //TODO 管理员登录
     * @Date 14:56 2018/11/21
     * @Param []
     **/
    @PostMapping("/admin")
    public BaseResponseVo adminLogin() {
        return null;
    }

    /*
     * @Autor wang
     * @Description //TODO 发送邮件找回密码
     * @Date 23:42 2018/12/18
     * @Param [userEmail]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
    **/
    @PostMapping("/pass")
    public BaseResponseVo recoverPass(@Email @RequestParam String userEmail){
        Boolean b = userService.recoverPassword(userEmail);
        if (b){
            return BaseResponseVo.success("邮件已发送");
        }else {
            return BaseResponseVo.fail("邮箱不存在");
        }
    }

    /*
     * @Autor wang
     * @Description //TODO 通过密文修改密码
     * @Date 23:43 2018/12/18
     * @Param
     * @return
    **/
    @PostMapping("/newpass")
    public BaseResponseVo updateNewPwd(@RequestParam String desCode,@RequestParam String newPwd){
        Boolean b = userService.updatePwd(desCode,newPwd);
        if (b){
            return BaseResponseVo.success("密码修改成功");
        }else {
            return BaseResponseVo.fail("密码修改失败");
        }
    }
}
