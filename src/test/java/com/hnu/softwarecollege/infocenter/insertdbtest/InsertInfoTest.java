package com.hnu.softwarecollege.infocenter.insertdbtest;

import com.hnu.softwarecollege.infocenter.entity.po.*;
import com.hnu.softwarecollege.infocenter.mapper.*;
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
    @Resource
    CenterDegreePoMapper centerDegreePoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertCenterDegree(){
        CenterDegreePo centerDegreePo = new CenterDegreePo(1l,"2016-2017",
                "大学生心理健康教育","素质类",2d,89d,
                3.7,"正常考试",2016011372,"刘亚双");
        CenterDegreePo centerDegreePo1 = new CenterDegreePo(1l,"2016-2017",
                "计算机导论","正常考试",
                3d,83d,3.3d,"正常考试",2016011372,"刘亚双");

        int num = centerDegreePoMapper.insertSelective(centerDegreePo);
        int num1 = centerDegreePoMapper.insertSelective(centerDegreePo1);
        if((num+num1)>=2){
            log.info("CenterDegree insert successs");
        }else{
            log.info("CenterDegree insert fail");
        }
    }

    @Resource
    HotsPotPoMapper hotsPotPoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertHotsPot(){
        HotsPotPo hotsPotPo = new HotsPotPo("张卫健光头原因","2327163",
                "http://s.weibo.com/weibo?q=%23%E5%BC%A0%E5%8D%AB%E5%81%A5%E5%85%89%E5%A4%B4%E5%8E%9F%E5%9B%A0%23&Refer=top");
        HotsPotPo hotsPotPo1 = new HotsPotPo("孟晚舟获得保释","1113905",
                "http://s.weibo.com/weibo?q=%23%E5%AD%9F%E6%99%9A%E8%88%9F%E8%8E%B7%E5%BE%97%E4%BF%9D%E9%87%8A%23&Refer=top");
        HotsPotPo hotsPotPo2 = new HotsPotPo("酒店回应插座暗藏摄像头","691386" ,
                "http://s.weibo.com/weibo?q=%23%E9%85%92%E5%BA%97%E5%9B%9E%E5%BA%94%E6%8F%92%E5%BA%A7%E6%9A%97%E8%97%8F%E6%91%84%E5%83%8F%E5%A4%B4%23&Refer=top");
        int num = hotsPotPoMapper.insertSelective(hotsPotPo);
        int num1 = hotsPotPoMapper.insertSelective(hotsPotPo1);
        int num2 = hotsPotPoMapper.insertSelective(hotsPotPo2);
        if((num+num1+num2)>=3){
            log.info("HotsPot insert success");
        }else{
            log.info("HotsPot insert fail");
        }
    }
}
