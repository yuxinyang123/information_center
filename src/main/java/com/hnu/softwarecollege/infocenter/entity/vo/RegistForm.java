package com.hnu.softwarecollege.infocenter.entity.vo;

import com.hnu.softwarecollege.infocenter.entity.po.UserInformationPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @program: infocenter
 * @description: 未来使用json注解
 * @author: yu
 * @create: 2018-11-07 00:41
 **/
public class RegistForm {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String userPass;
    @NotEmpty
    @Email
    private String userEmail;
    @NotEmpty
    private String userPhone;
    @NotEmpty
    private String educationalNum;
    @NotEmpty
    private String educationalPass;
    public UserPo toUserPo() {
        UserPo userPo = new UserPo();
        userPo.setUserEmail(getUserEmail());
        userPo.setUserName(getUserName());
        userPo.setUserPhone(getUserPhone());
        userPo.setUserPass(getUserPass());
        userPo.setUserIsban("false");
        return userPo;
    }

    public UserInformationPo toUserUserInformationPo(Long userkey){
        UserInformationPo userInformationPo = new UserInformationPo();
        userInformationPo.setUserKey(userkey);
        userInformationPo.setInfNum(Integer.parseInt(getEducationalNum()));
        userInformationPo.setInfPass(getEducationalPass());
        return userInformationPo;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEducationalNum() {
        return educationalNum;
    }

    public void setEducationalNum(String educationalNum) {
        this.educationalNum = educationalNum;
    }

    public String getEducationalPass() {
        return educationalPass;
    }

    public void setEducationalPass(String educationalPass) {
        this.educationalPass = educationalPass;
    }
}
