package com.hnu.softwarecollege.infocenter.controller;


import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.service.UserService;
import com.hnu.softwarecollege.infocenter.util.TokenUtil;
import com.hnu.softwarecollege.infocenter.util.VerifyCodeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;

@RestController
@RequestMapping("access")
public class AccessController {

    @Resource
    UserService userService;


    /**
    * @Description:  生成跨域cookie
    * @Param: [name, value]
    * @return: javax.servlet.http.Cookie
    * @Author: yu
    * @Date: 2018/11/9 2:30
    **/
    private Cookie getCookie(String name,String value){
        Cookie cookie = new Cookie(name,value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
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
            @RequestBody @Valid LoginForm loginForm,
            HttpServletResponse response){
        //will set userContext
        boolean isTrue = userService.verifyUser(loginForm);
        if(isTrue){
            String token = TokenUtil.createToken();
            response.addCookie(getCookie("token",token));
            return BaseResponseVo.success("login success");
        }else {
            return BaseResponseVo.fail("login fail");
        }
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 获取二维码
     * @Date 14:55 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/verifycode")
    public BaseResponseVo getVerifycode(HttpServletResponse response, HttpSession session){
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        session.setAttribute("verifycode",verifyCode);
        try {
            VerifyCodeUtil.outputVerifyImage(response.getOutputStream(),4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResponseVo.success(verifyCode);
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 验证验证码
     * @Date 10:13 2018/11/22
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/verifycode")
    public BaseResponseVo createVerifycode(@NotBlank @RequestParam("verifycode") String verifycode, HttpSession session){
        String serverVerifycode = (String) session.getAttribute("verigycode");
        if(verifycode.equals(serverVerifycode)){
            return BaseResponseVo.success("verify success");
        }else{
            return BaseResponseVo.fail("verify fail");
        }

    }

    /**
     * @Author yuxinyang
     * @Description //TODO 管理员登录
     * @Date 14:56 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/admin")
    public BaseResponseVo adminLogin(){
        return null;
    }
}
