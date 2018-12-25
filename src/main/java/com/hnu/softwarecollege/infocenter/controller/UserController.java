package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.client.FaceRecognition;
import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.ProvingForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.entity.vo.UserInfoForm;
import com.hnu.softwarecollege.infocenter.service.CenterService;
import com.hnu.softwarecollege.infocenter.service.UserService;
import com.hnu.softwarecollege.infocenter.util.Base64PicUtil;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;
    @Resource
    CenterService centerService;


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
            Errors errors) {
        if (errors.hasErrors()) {
            return BaseResponseVo.error("fileds not null");
        }
        Long userKey = userService.createUser(registForm);
        if (userKey != null) {
            centerService.getGrade(userKey);
            return BaseResponseVo.success();
        } else {
            return BaseResponseVo.error("create fail");
        }
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author wangzixuan
     * @Description //TODO 修改用户信息
     * @Date 14:59 2018/12/12
     * @Param [userInfoForm]
     **/
    @PutMapping("/info")
    public BaseResponseVo updateUserInfo(@RequestBody UserInfoForm userInfoForm,Errors errors) {
        if (errors.hasErrors()){
            return BaseResponseVo.error("have an error");
        }
        UserPo userPo = ThreadContext.getUserContext();
        Long userkey = userPo.getUserId();
//        Long userkey = 1l;
        userInfoForm.setUserkey(userkey);
        Integer i = userService.updateUserInfo(userInfoForm);
        if (i != null) {
            i = 200;
            return BaseResponseVo.success();
        } else {
            i = 500;
            return BaseResponseVo.fail("500");
        }
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author wangzixuan
     * @Description //TODO 查找用户信息
     * @Date 15:00 2018/11/21
     * @Param []
     **/
    @GetMapping("/info")
    public BaseResponseVo getUserInfo(@RequestParam("token") String token, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                if (cookie.getValue().equals(token))
                    return BaseResponseVo.success(userService.findUserAndUserinfo(ThreadContext.getUserContext().getUserId()));
                else
                    return BaseResponseVo.fail("token error");
            }
        }
        return BaseResponseVo.fail("please login in");
    }


    /*
     * @Author 刘亚双
     * @Description //TODO 修改密码前，验证密码
     * @Date 2018/12/12 15:35
     * @Param [pass, email]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/pass")
    public BaseResponseVo provingPassword(@RequestBody ProvingForm provingForm) {
        boolean flag = userService.provingPass(provingForm.getPass(), provingForm.getEmail());
        if (flag == true) {
            return BaseResponseVo.success("身份验证成功");
        } else {
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
    public BaseResponseVo changePassword(@RequestBody Map<String, Object> map) {
        String newpass = (String) map.get("newpass");
        boolean bool = userService.changePassword(newpass);
        if (bool == true) {
            return BaseResponseVo.success("修改成功");
        } else {
            return BaseResponseVo.error("修改失败");
        }
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author yuxinyang
     * @Description //TODO 获取用户私信信息列表
     * @Date 15:03 2018/11/21
     * @Param []
     **/
    @GetMapping("/private")
    public BaseResponseVo getPrivateMsg() {
        return null;
    }

    /**
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @Author yuxinyang
     * @Description //TODO 回复用户私信
     * @Date 15:08 2018/11/21
     * @Param []
     **/
    @PostMapping("/private")
    public BaseResponseVo replayPrivateMsh() {
        return null;
    }

    /**
     * @param
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     * @author ying
     * @description //TODO 添加用户人脸至人脸库
     * @date 0:44 2018/12/23
     **/
    @PutMapping("/face")
    public BaseResponseVo addUserFace(@RequestBody Map<String, Object> map) {
        String base64 = (String) map.get("base64");
        base64 = Base64PicUtil.handlePic(base64);
        String userId = String.valueOf(ThreadContext.getUserContext().getUserId());
        String email = ThreadContext.getUserContext().getUserEmail();
        return BaseResponseVo.success(FaceRecognition.addUser(base64, userId, email).toMap());
    }

}
