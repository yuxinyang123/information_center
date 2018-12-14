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
import java.util.Date;

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

    @Resource
    ResTypePoMapper resTypePoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertResType(){
        ResTypePo resTypePo = new ResTypePo(1l,"招聘信息");
        ResTypePo resTypePo1 = new ResTypePo(2l,"兼职信息");
        ResTypePo resTypePo2 = new ResTypePo(3l,"新闻信息");
        int num = resTypePoMapper.insertSelective(resTypePo);
        int num1 = resTypePoMapper.insertSelective(resTypePo1);
        int num2 = resTypePoMapper.insertSelective(resTypePo2);
        if((num+num1+num2)==3){
            log.info("ResType insert success");
        }else{
            log.info("ResType insert fail");
        }
    }


    @Resource
    ResourcePoMapper resourcePoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertResource(){
        ResourcePo resourcePo = new ResourcePo(1l,"招聘启示","admin","招聘平台",new Date(2018-12-10),"招聘管理人员");
        ResourcePo resourcePo1 = new ResourcePo(2l,"兼职信息启示","admin","个人",new Date(2018-12-10),"发传单兼职");
        ResourcePo resourcePo2 = new ResourcePo(3l,"陈羽凡吸毒被抓","admin","网络",new Date(2018-12-05),"吸毒被抓");
        ResourcePo resourcePo3 = new ResourcePo(3l,"蒋劲夫","admin","网络",new Date(2018-12-11),"蒋劲夫被抓");
        int num = resourcePoMapper.insertSelective(resourcePo);
        int num1 = resourcePoMapper.insertSelective(resourcePo1);
        int num2 = resourcePoMapper.insertSelective(resourcePo2);
        int num3 = resourcePoMapper.insertSelective(resourcePo3);
        if((num+num1+num2+num3)>=4){
            log.info("Resource insert success");
        }else{
            log.info("Resource insert fail");
        }
    }

    @Resource
    SyllabusPoMapper syllabusPoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertSyllabus(){
        SyllabusPo syllabusPo = new SyllabusPo(1l,"分布式系统原理★",1,
                10,1,4,"星期一","软件C-302","王伟",1l);
        SyllabusPo syllabusPo1 = new SyllabusPo(2l,"Java与大数据分析开发实训一★",
                11,16,1,4,"星期一",
                "软件C-302","王鹏帆",1l);
        SyllabusPo syllabusPo2 = new SyllabusPo(3l,"分布式系统原理★",1,
                10,6,9,"星期一","软件C-302","王伟",1l);

        SyllabusPo syllabusPo3 = new SyllabusPo(4l,"软件工程★",1,
                10,1,4,"星期二","软件C-302","王伟",1l);
        SyllabusPo syllabusPo4 = new SyllabusPo(5l,"Java企业级应用开发★",1,
                10,6,9,"星期二","软件C-302","王伟",1l);

        SyllabusPo syllabusPo5 = new SyllabusPo(6l,"Java企业级应用开发★",1,
                10,1,4,"星期三","软件C-302","王伟",1l);
        SyllabusPo syllabusPo6 = new SyllabusPo(7l,"Java与大数据分析开发实训一★",10,
                16,1,4,"星期三","软件C-302","王伟",1l);
        SyllabusPo syllabusPo7 = new SyllabusPo(8l,"JavaEE★",1,10,
                6,9,"星期三","软件C-302","王伟",1l);

        SyllabusPo syllabusPo8 = new SyllabusPo(9l,"JavaEE★",1,
                10,1,4,"星期四","软件C-302","王伟",1l);

        int num = syllabusPoMapper.insertSelective(syllabusPo);
        int num1 = syllabusPoMapper.insertSelective(syllabusPo1);
        int num2 = syllabusPoMapper.insertSelective(syllabusPo2);
        int num3 = syllabusPoMapper.insertSelective(syllabusPo3);
        int num4 = syllabusPoMapper.insertSelective(syllabusPo4);
        int num5 = syllabusPoMapper.insertSelective(syllabusPo5);
        int num6 = syllabusPoMapper.insertSelective(syllabusPo6);
        int num7 = syllabusPoMapper.insertSelective(syllabusPo7);
        int num8 = syllabusPoMapper.insertSelective(syllabusPo8);
        int sum = num+num1+num2+num3+num4+num5+num6+num7+num8;
        if(sum==9){
            log.info("Syllabus insert success");
        }else{
            log.info("Syllabus insert fail");
        }
    }

    @Resource
    WeatherPoMapper weatherPoMapper;
    @Test
    @Transient
    @Rollback(false)
    public void insertWeather(){
        WeatherPo weatherPo = new WeatherPo(101090101,"石家庄","26日星期一",
                "07:13","高温 15.0℃","低温 2.0℃","15",
                "17:04",240f,"阴晴之间，谨防紫外线侵扰","多云","<3级","西风");
        WeatherPo weatherPo1 = new WeatherPo(101090301,"张家口","26日星期一",
                "07:18","高温 9.0℃","低温 -7.0℃","5","16:56",60f,
                "愿你拥有比阳光明媚的心情","晴","3-4级","西北风");
        WeatherPo weatherPo2 = new WeatherPo(101090701,"沧州市","22日星期四",
                "07:00","高温 10.0℃","低温 -2.0℃","6",
                "16:56",94f,"愿你拥有比阳光明媚的心情","晴","<3级","东南风");
        int num = weatherPoMapper.insertSelective(weatherPo);
        int num1 = weatherPoMapper.insertSelective(weatherPo1);
        int num2 = weatherPoMapper.insertSelective(weatherPo2);
        if((num+num1+num2)>=3){
            log.info("Weather insert success");
        }else{
            log.info("Weather insert fail");
        }
    }

}
