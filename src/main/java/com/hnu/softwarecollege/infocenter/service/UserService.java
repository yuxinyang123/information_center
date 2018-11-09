package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
public interface UserService {

    public boolean createUser(RegistForm registForm);

    public boolean verifyUser(LoginForm loginForm);

}
