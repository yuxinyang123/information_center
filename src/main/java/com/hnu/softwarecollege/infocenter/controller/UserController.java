package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;
    

    /** 
    * @Description: 用户注册
    * @Param: [registForm] 
    * @return: com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo 
    * @Author: yu 
    * @Date: 2018/11/7 
    **/
    @PostMapping("regist")
    @ResponseBody
    public BaseResponseVo register(
            @RequestBody @Valid RegistForm registForm,
            Errors errors){
        if(errors.hasErrors()){
            return BaseResponseVo.error("fileds not null");
        }
        boolean flag=userService.createUser(registForm);
        if(flag == true){
            return BaseResponseVo.success();
        }else{
            return BaseResponseVo.error("create fail");
        }
    }

    public BaseResponseVo login(@RequestBody @Valid LoginForm loginForm){
        return BaseResponseVo.success();
    }
}
