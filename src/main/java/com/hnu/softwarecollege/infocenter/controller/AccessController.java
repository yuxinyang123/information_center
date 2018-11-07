package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("access")
public class AccessController {


    /** 
    * @Description: 用户登录
    * @Param: [loginForm] 
    * @return: com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo 
    * @Author: yu 
    * @Date: 2018/11/7 
    **/
    @GetMapping("login")
    @ResponseBody
    public BaseResponseVo login(LoginForm loginForm){

        return BaseResponseVo.success();
    }
}
