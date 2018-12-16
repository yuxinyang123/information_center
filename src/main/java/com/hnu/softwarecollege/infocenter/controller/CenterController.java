package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;
import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.entity.vo.*;
import com.hnu.softwarecollege.infocenter.mapper.CenterPoMapper;
import com.hnu.softwarecollege.infocenter.service.CenterService;
import com.hnu.softwarecollege.infocenter.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 10:28
 **/
@RestController
@Slf4j
@RequestMapping("/center")
public class CenterController {

    @Resource
    WeatherService weatherService;
    @Resource
    CenterPoMapper centerPoMapper;
    @Resource
    CenterService centerService;

    /**
     * @Author yuxinyang
     * @Description //TODO 获取天气信息
     * @Date 10:53 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/weather")
    public BaseResponseVo getWeatherInfo(){
        int code = weatherService.getcitycode();
        if(code==0){
            return BaseResponseVo.error("没有查询到citycode");
        }
        String citycode = code+"";
        WeatherPo weatherPo = weatherService.Weather(citycode);
        if(weatherPo==null){
            return BaseResponseVo.error("没有找到对应城市的天气信息");
        }
        return BaseResponseVo.success(weatherPo);
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 修改个人中心天气信息
     * @Date 10:56 2018/11/21
     * @Param [weatherForm]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/weather")
    public BaseResponseVo updateWeatherInfo(@RequestBody WeatherForm weatherForm) {
        int num = 0;
        String code = weatherService.findcitycode(weatherForm.getCityname());
        if (code.equals(null)) {
            return BaseResponseVo.error("没有找到该城市对应的ID");
        } else {
            num = weatherService.updateWeatherInfo(code);
        }
        if (num != 0) {
            return BaseResponseVo.error("修改失败");
        }else{
            return BaseResponseVo.success("修改成功");
        }
    }
    /**
     * @Author yuxinyang
     * @Description //TODO 根据UserKey 获取教务系统的账号密码，执行python脚本，将爬虫数据插入到数据库中
     * @Date 11:07 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/spider")
    public BaseResponseVo runSpider(){
        centerService.getGrade();
        return BaseResponseVo.success("查询，插入数据库成功");
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 通过UserKey 从数据库中查询数据
     * @Date 2018/12/11 15:53
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/grade")
    public BaseResponseVo grade(){
        List<CenterDegreePo> poList = centerService.gradeDB();
        if(poList.size()==0){
            return BaseResponseVo.error("没有查询的数据");
        }else {
            return BaseResponseVo.success(poList);
        }
    }
    /**
     * @Author yuxinyang
     * @Description //TODO 获取成绩预测信息
     * @Date 11:07 2018/11/21
     * @Param [gradeForecastForm]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/grade")
    public BaseResponseVo gradeForecast(@RequestBody GradeForecastForm gradeForecastForm){
        String result = centerService.getGradeForeast(gradeForecastForm.getStudentID(),gradeForecastForm.getCourseType(),
                gradeForecastForm.getTestType(),gradeForecastForm.getGainCredit());
        System.out.println(result);
        return BaseResponseVo.success(result);
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 得到已存储的课程表
     * @Date 11:09 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/curriculum")
    public BaseResponseVo getCurriculum(@RequestParam Long userkey){
        SyllabusVo syllabusVo = centerService.getCourseTable(userkey);
        return BaseResponseVo.success(syllabusVo);
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 课程表内自定义添加新课程
     * @Date 11:10 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/curriculum")
    public BaseResponseVo putCurriculum(@RequestBody CurriculumForm curriculumForm){
        centerService.putCurriculum(curriculumForm);

        return null;
    }

    /**
     * @Author wangzixuan
     * @Description //TODO 得到热点信息
     * @Date 11:16 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/hotpot")
    public BaseResponseVo getHotpot(@RequestParam int pageNum,@RequestParam int pageSize){
        List<HotsPotPo> hotsPotPoList;

        hotsPotPoList = centerService.getHotPot(pageNum,pageSize);

//        if(hotsPotPoList != null){
//            log.info("ok");
//        }
//        for(HotsPotPo po : hotsPotPoList){
//            System.out.print(po.getHotspotTitle());
//        }
        return BaseResponseVo.success(hotsPotPoList);
    }

    /*
     * @Autor wang
     * @Description //TODO 向前端返回加权平均分，已获得学分,绩点，通识选修学分
     * @Date 14:42 2018/12/11
     * @Param
     * @return
    **/

    @GetMapping("/fourtag")
    public BaseResponseVo getFourTag(){
        FourTag fourTag = new FourTag();
        fourTag = centerService.selectForFouttag();
        return BaseResponseVo.success(fourTag);
    }

}
