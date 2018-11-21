package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.CurriculumForm;
import com.hnu.softwarecollege.infocenter.entity.vo.GradeForecastForm;
import com.hnu.softwarecollege.infocenter.entity.vo.WeatherForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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


    /**
     * @Author yuxinyang
     * @Description //TODO 获取天气信息
     * @Date 10:53 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/weather")
    public BaseResponseVo getWeatherInfo(){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 修改个人中心天气信息
     * @Date 10:56 2018/11/21
     * @Param [weatherForm]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/weather")
    public BaseResponseVo updateWeatherInfo(@RequestBody WeatherForm weatherForm){

        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 获取成绩信息
     * @Date 11:07 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/grade")
    public BaseResponseVo getGrade(){
        return null;
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
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 得到已存储的课程表
     * @Date 11:09 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/curriculum")
    public BaseResponseVo getCurriculum(){
        return null;
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
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 得到热点信息
     * @Date 11:16 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/hotpot")
    public BaseResponseVo getHotpot(){
        return null;
    }

}
