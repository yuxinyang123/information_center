package com.hnu.softwarecollege.infocenter.insertdbtest;

import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserInformationPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.mapper.CenterPoMapper;
import com.hnu.softwarecollege.infocenter.mapper.UserInformationPoMapper;
import com.hnu.softwarecollege.infocenter.mapper.UserPoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.beans.Transient;

/**
 * @ClassName InsertInfoTest
 * @Description TODO 数据库数据的插入
 * @Author liu
 * @Date 2018/12/13 9:46
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class InsertInfoTest {
    @Resource
    UserPoMapper userPoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertUser(){
        UserPo userPo = new UserPo("刘亚双","liuyashuang@sina.com","13072695881","liuyashuang","1");
        UserPo userPo1 = new UserPo("孟响","mengxiang@sina.com","15830398729","mengxiang","1");
        UserPo userPo2 = new UserPo("马六","maliu@sina.com","15931317998","maliu","1");
        int num = userPoMapper.insertSelective(userPo);
        int num1 = userPoMapper.insertSelective(userPo1);
        int num2 = userPoMapper.insertSelective(userPo2);
        if((num+num1+num2)>=3){
            log.info("User插入成功");
        }else{
            log.info("User插入失败");
        }

    }

    @Resource
    UserInformationPoMapper userInformationPoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertUserInfo(){
        UserInformationPo userInformationPo = new UserInformationPo(1l,2016011372,
                "liu1996.","我最帅","软件学院","软件工程",
                "一班","男","张家口","21");
        UserInformationPo userInformationPo1 = new UserInformationPo(2l,2016011346,"919919",
                "我最丑","软件学院","软件工程","一班",
                "男","北京","21");

        int num = userInformationPoMapper.insertSelective(userInformationPo);
        int num1 = userInformationPoMapper.insertSelective(userInformationPo1);
        if((num+num1)>=2){
         log.info("UserInfo插入成功");
        }else{
            log.info("UserInfo插入失败");
        }
    }

    @Resource
    CenterPoMapper centerPoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertCenter(){
        CenterPo centerPo = new CenterPo(1l,1l,101090301);
        CenterPo centerPo1 = new CenterPo(2l,2l,101090101);
        CenterPo centerPo2 = new CenterPo(3l,3l,101090701);
        int num = centerPoMapper.insertSelective(centerPo);
        int num1 = centerPoMapper.insertSelective(centerPo1);
        int num2 = centerPoMapper.insertSelective(centerPo2);
        if((num+num1+num2)>=3){
            log.info("Center insert success");
        }else{
            log.info("Center insert fail");
        }
    }
}
