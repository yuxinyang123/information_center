package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.UserAndUserinfoPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.entity.vo.UserInfoForm;
import com.hnu.softwarecollege.infocenter.exception.UserFaceException;

public interface UserService {

    public Long createUser(RegistForm registForm);

    public boolean verifyUser(LoginForm loginForm);

    public UserAndUserinfoPo findUserAndUserinfo(Long id);

    public int updateUserInfo(UserInfoForm userInfoForm);

    public boolean provingPass(String password,String email);

    public boolean changePassword(String newpass);

    public int verifyUserFace(String base64,String email) throws UserFaceException;

    public boolean recoverPassword(String email);

    public boolean updatePwd(String descode,String newpwd);

}
