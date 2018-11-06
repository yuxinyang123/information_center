package com.hnu.softwarecollege.infocenter.entity.po;

public class UserPo {
    private Long userId;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String userPass;

    private String userIsban;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserIsban() {
        return userIsban;
    }

    public void setUserIsban(String userIsban) {
        this.userIsban = userIsban == null ? null : userIsban.trim();
    }
}