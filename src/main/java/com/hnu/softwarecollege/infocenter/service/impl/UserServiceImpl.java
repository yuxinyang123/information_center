package com.hnu.softwarecollege.infocenter.service.impl;

import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.vo.RegistForm;
import com.hnu.softwarecollege.infocenter.mapper.UserPoMapper;
import com.hnu.softwarecollege.infocenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    @Resource
    UserPoMapper userPoMapper;

    @Override
    @Transient
    public boolean createUser(RegistForm registForm) {
        UserPo userPo = userPoMapper.selectByUserName(registForm.getUserName());
        if(userPo!=null){
            logger.debug("this name:{} has been registed!",registForm.getUserName());
            return false;
        }else{
            int flag=userPoMapper.insert(registForm.toUserPo());
            logger.debug("the create return num is {}",flag);
            if(flag==1){
                logger.debug("create a user name:{}",registForm.getUserName());
                return true;
            }
            logger.error("create fail! user name:{}",registForm.getUserName());
            return false;
        }
    }
}
