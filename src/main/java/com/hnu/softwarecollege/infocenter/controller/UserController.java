package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.ProvingForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.entity.vo.UserInfoForm;
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

    /**
     * @Author yuxinyang
     * @Description //TODO 修改用户信息
     * @Date 14:59 2018/11/21
     * @Param [userInfoForm]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/info")
    public BaseResponseVo updateUserInfo(@RequestBody UserInfoForm userInfoForm){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 查找用户信息
     * @Date 15:00 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/info")
    public BaseResponseVo getUserInfo(){
        return null;
    }


    /*
     * @Author 刘亚双
     * @Description //TODO 修改密码前，验证密码
     * @Date 2018/12/12 15:35
     * @Param [pass, email]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/pass")
    public BaseResponseVo provingPassword(@RequestBody ProvingForm provingForm){
        boolean flag = userService.provingPass(provingForm.getPass(),provingForm.getEmail());
        if(flag == true){
            return BaseResponseVo.success("身份验证成功");
        }else{
            return BaseResponseVo.error("验证身份错误");
        }
    }

    /*
     * @Author 刘亚双
     * @Description //TODO 验证了身份后修改密码
     * @Date 2018/12/12 15:45
     * @Param [newpass]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/pass")
    public BaseResponseVo changePassword(@PathVariable("newpass") String newpass){
        boolean bool = userService.changePassword(newpass);
        if(bool == true){
            return BaseResponseVo.success("修改成功");
        }else{
            return BaseResponseVo.error("修改失败");
        }
    }
    /**
     * @Author yuxinyang
     * @Description //TODO 获取用户私信信息列表
     * @Date 15:03 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/private")
    public BaseResponseVo getPrivateMsg(){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 回复用户私信
     * @Date 15:08 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/private")
    public BaseResponseVo replayPrivateMsh(){
        return null;
    }


}
