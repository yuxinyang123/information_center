package com.hnu.softwarecollege.infocenter.entity.po;

public class UserInformationPo {
    private Long infId;

    private Long userKey;

    private Integer infNum;

    private String infPass;

    private String infSignature;

    private String infAcademy;

    private String infMajor;

    private String infClass;

    private String infSex;

    private String infLocaltion;

    private String infAge;

    public UserInformationPo(){}

    public UserInformationPo(Long userKey, Integer infNum, String infPass, String infSignature, String infAcademy,
                             String infMajor, String infClass, String infSex, String infLocaltion, String infAge) {
        this.userKey = userKey;
        this.infNum = infNum;
        this.infPass = infPass;
        this.infSignature = infSignature;
        this.infAcademy = infAcademy;
        this.infMajor = infMajor;
        this.infClass = infClass;
        this.infSex = infSex;
        this.infLocaltion = infLocaltion;
        this.infAge = infAge;
    }

    public Long getInfId() {
        return infId;
    }

    public void setInfId(Long infId) {
        this.infId = infId;
    }

    public Long getUserKey() {
        return userKey;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
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
        this.infPass = infPass == null ? null : infPass.trim();
    }

    public String getInfSignature() {
        return infSignature;
    }

    public void setInfSignature(String infSignature) {
        this.infSignature = infSignature == null ? null : infSignature.trim();
    }

    public String getInfAcademy() {
        return infAcademy;
    }

    public void setInfAcademy(String infAcademy) {
        this.infAcademy = infAcademy == null ? null : infAcademy.trim();
    }

    public String getInfMajor() {
        return infMajor;
    }

    public void setInfMajor(String infMajor) {
        this.infMajor = infMajor == null ? null : infMajor.trim();
    }

    public String getInfClass() {
        return infClass;
    }

    public void setInfClass(String infClass) {
        this.infClass = infClass == null ? null : infClass.trim();
    }

    public String getInfSex() {
        return infSex;
    }

    public void setInfSex(String infSex) {
        this.infSex = infSex == null ? null : infSex.trim();
    }

    public String getInfLocaltion() {
        return infLocaltion;
    }

    public void setInfLocaltion(String infLocaltion) {
        this.infLocaltion = infLocaltion == null ? null : infLocaltion.trim();
    }

    public String getInfAge() {
        return infAge;
    }

    public void setInfAge(String infAge) {
        this.infAge = infAge == null ? null : infAge.trim();
    }
}