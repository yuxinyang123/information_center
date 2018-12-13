package com.hnu.softwarecollege.infocenter.entity.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @ClassName ProvingForm
 * @Description TODO
 * @Author liu
 * @Date 2018/12/12 16:10
 * @Version 1.0
 **/
public class ProvingForm {
    @NotEmpty
    private String pass;
    @NotEmpty
    @Email
    private String email;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
