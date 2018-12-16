package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName UserAndUserinfoPo
 * @Description TODO
 * @Author wang
 * @Date 2018/12/12 15:01
 * @Version 1.0
 **/
public class UserAndUserinfoPo {

    @JsonProperty
    private Integer userId;
    @JsonProperty("num")
    private Integer infNum;
    @JsonProperty("signature")
    private String infSignature;
    @JsonProperty("academy")
    private String infAcademy;
    @JsonProperty("major")
    private String infMajor;
    @JsonProperty("class")
    private String infClass;
    @JsonProperty("sex")
    private String infSex;
    @JsonProperty("location")
    private String infLocaltion;
    @JsonProperty("age")
    private String infAge;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String userEmail;
    @JsonProperty
    private String userPhone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInfNum() {
        return infNum;
    }

    public void setInfNum(Integer infNum) {
        this.infNum = infNum;
    }

    public String getInfSignature() {
        return infSignature;
    }

    public void setInfSignature(String infSignature) {
        this.infSignature = infSignature;
    }

    public String getInfAcademy() {
        return infAcademy;
    }

    public void setInfAcademy(String infAcademy) {
        this.infAcademy = infAcademy;
    }

    public String getInfMajor() {
        return infMajor;
    }

    public void setInfMajor(String infMajor) {
        this.infMajor = infMajor;
    }

    public String getInfClass() {
        return infClass;
    }

    public void setInfClass(String infClass) {
        this.infClass = infClass;
    }

    public String getInfSex() {
        return infSex;
    }

    public void setInfSex(String infSex) {
        this.infSex = infSex;
    }

    public String getInfLocaltion() {
        return infLocaltion;
    }

    public void setInfLocaltion(String infLocaltion) {
        this.infLocaltion = infLocaltion;
    }

    public String getInfAge() {
        return infAge;
    }

    public void setInfAge(String infAge) {
        this.infAge = infAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
