package com.hnu.softwarecollege.infocenter.service.impl;

import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserAndUserinfoPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.vo.LoginForm;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.entity.vo.UserInfoForm;
import com.hnu.softwarecollege.infocenter.mapper.CenterPoMapper;
import com.hnu.softwarecollege.infocenter.mapper.UserInformationPoMapper;
import com.hnu.softwarecollege.infocenter.mapper.UserPoMapper;
import com.hnu.softwarecollege.infocenter.service.UserService;
import com.hnu.softwarecollege.infocenter.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Transient;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-07 00:48
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
//    Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    @Resource
    UserPoMapper userPoMapper;
    @Resource
    UserInformationPoMapper userInformationPoMapper;
    @Resource
    CenterPoMapper centerPoMapper;

    /**
     * @Description: 用户注册
     * @Param: [registForm]
     * @return: boolean
     * @Author: yu
     * @Date: 2018/11/8 0:06
     **/
    @Override
    @Transient
    public Long createUser(RegistForm registForm) {
        UserPo userPo = userPoMapper.selectByUserEmail(registForm.getUserEmail());

        if (userPo != null) {

            log.info("the email:{} has been registed!", registForm.getUserName());

            return null;

        } else {

            int flag = userPoMapper.insert(registForm.toUserPo());

            log.debug("the create return num is {}", flag);
            Long userkey = userPoMapper.selectByUserEmail(registForm.getUserEmail()).getUserId();
            int num1 = userInformationPoMapper.insertSelective(registForm.toUserUserInformationPo(userkey));

            CenterPo centerPo = new CenterPo();
            centerPo.setUserKey(userkey);
            centerPo.setWeatherCode(101090101);
            int num2 = centerPoMapper.insertSelective(centerPo);

            if (flag == 1 && num1 == 1 && num2 == 1) {

                log.debug("create a user name:{}", registForm.getUserName());
                return userkey;
            }
            log.error("create fail! user name:{}", registForm.getUserName());
            return null;
        }
    }

    /**
     * @Description: 用户登录验证
     * @Param: [loginForm]
     * @return: boolean
     * @Author: yu
     * @Date: 2018/11/8 11:03
     **/
    @Override
    public boolean verifyUser(LoginForm loginForm) {
        UserPo userPo = userPoMapper.selectByUserSelective(loginForm.toUserPo());
        if (userPo == null) {
            log.info("the user:{} doesn't exist", loginForm.getEmail());
            return false;
        }
        // todo setContext
        ThreadContext.setUserContext(userPo);
        log.info("the user:{} verify success", userPo.getUserEmail());
        return true;
    }


    /*
     * @Autor wangzixuan
     * @Description //TODO 获取用户信息
     * @Date 15:20 2018/12/12
     * @Param
     * @return
     **/
    public UserAndUserinfoPo findUserAndUserinfo() {
        UserPo userPo = ThreadContext.getUserContext();
        Long userkey = userPo.getUserId();
//        Long userkey = 1l;
        UserAndUserinfoPo userAndUserinfoPo;
        userAndUserinfoPo = userInformationPoMapper.infoselectByUserkey(userkey);
//        System.out.println(userAndUserinfoPo);
//        userAndUserinfoPo = userInformationPoMapper.infoselectByUserkey(userkey);
        return userAndUserinfoPo;
    }

    /*
     * @Autor wang
     * @Description //TODO 更新数据库中的用户信息
     * @Date 16:18 2018/12/12
     * @Param
     * @return
     **/
    public int updateUserInfo(UserInfoForm userInfoForm) {

        int i = userInformationPoMapper.updateByuserKeySelective(userInfoForm);
        return i;
    }

    /**
     * @return boolean
     * @Author 刘亚双
     * @Description //TODO 修改密码前验证密码
     * @Date 2018/12/12 15:37
     * @Param [password, email]
     **/
    @Override
    public boolean provingPass(String password, String email) {
        UserPo userPo = userPoMapper.selectByUserEmail(email);
        if (userPo.getUserPass().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return boolean
     * @Author 刘亚双
     * @Description //TODO 验证后修改密码
     * @Date 2018/12/12 16:00
     * @Param [newpass]
     **/
    @Override
    public boolean changePassword(String newpass) {
        UserPo userPo = ThreadContext.getUserContext();
        Long userkey = userPo.getUserId();
        int flag = userPoMapper.updatePasswordByPrimaryKeySelective(userkey, newpass);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }

    }

    @Resource
    private MailService mailService;
    @Resource
    private MailUtil mailUtil;
    @Override
    public boolean recoverPassword(String email) {
        log.info(email);
        UserPo userPo = userPoMapper.selectByUserEmail(email);
        if (userPo != null){
            String text = mailUtil.createLink(userPo);
            mailService.sendTextMail(email,"找回密码",text);
            return true;
        }else {
            log.error("邮箱错误");
            return false;
        }
    }

}
