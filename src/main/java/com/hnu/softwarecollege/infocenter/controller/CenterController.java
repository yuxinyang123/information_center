package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.CurriculumForm;
import com.hnu.softwarecollege.infocenter.entity.vo.GradeForecastForm;
import com.hnu.softwarecollege.infocenter.entity.vo.WeatherForm;
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
        //String citycode = weatherService.findcitycode(city);
        UserPo userPo = ThreadContext.getUserContext();
        Long centerId = centerPoMapper.selectByUserKey(userPo.getUserId());
        CenterPo centerPo = centerPoMapper.selectByPrimaryKey(centerId);
        int code = centerPo.getWeatherCode();
        String citycode = code+"";
        WeatherPo weatherPo = weatherService.Weather(citycode);
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
    public BaseResponseVo updateWeatherInfo(@RequestBody WeatherForm weatherForm){
        String code = weatherService.findcitycode(weatherForm.getCityname());
        int citycode = Integer.parseInt(code);
        UserPo userPo = ThreadContext.getUserContext();
        Long userid= userPo.getUserId();
        Long centerId = centerPoMapper.selectByUserKey(userid);
        centerPoMapper.updateWeatherCodeByPrimaryKey(citycode,centerId);
        return BaseResponseVo.success();
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 获取成绩信息
     * @Date 11:07 2018/11/21
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/grade")
    public BaseResponseVo getGrade(@RequestParam String Id,@RequestParam String password){
        String resulte = centerService.getGrade(Id,password);
        List<CenterDegreePo> list = centerService.transform(resulte);
        return BaseResponseVo.success(list);
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
