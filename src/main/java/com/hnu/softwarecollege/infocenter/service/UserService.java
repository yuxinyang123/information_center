package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.UserAndUserinfoPo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.entity.vo.UserInfoForm;

public interface UserService {

    Long createUser(RegistForm registForm);

    public boolean verifyUser(LoginForm loginForm);

    public UserAndUserinfoPo findUserAndUserinfo();

    public int updateUserInfo(UserInfoForm userInfoForm);

    public boolean provingPass(String password,String email);

    public boolean changePassword(String newpass);

    public boolean recoverPassword(String email);

    public boolean updatePwd(String descode,String newpwd);
}
