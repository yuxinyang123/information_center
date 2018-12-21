package com.hnu.softwarecollege.infocenter.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @program: infocenter
 * @description:
 * @author: wangzixuan
 * @create: 2018-11-21 15:01
 **/
public class UserInfoForm {

    private Long userkey;

    @JsonProperty("num")
    private Integer infNum;

    @JsonProperty("password")
    private String infPass;

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

    public Long getUserkey() {
        return userkey;
    }

    public void setUserkey(Long userkey) {
        this.userkey = userkey;
    }

    public Integer getInfNum() {
        return infNum;
    }

    public void setInfNum(Integer infNum) {
        this.infNum = infNum;
    }

    public String getInfPass() {
        return infPass;
    }

    public void setInfPass(String infPass) {
        this.infPass = infPass;
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
}
