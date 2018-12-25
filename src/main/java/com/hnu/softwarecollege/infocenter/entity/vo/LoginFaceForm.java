package com.hnu.softwarecollege.infocenter.entity.vo;

import javax.validation.constraints.NotBlank;

/**
 * @program: infocenter
 * @description: //TODO
 * @author: ying
 * @create: 2018-12-18 16:12
 **/
public class LoginFaceForm {
    @NotBlank
    public String userEmail;
    @NotBlank
    public String pic;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
