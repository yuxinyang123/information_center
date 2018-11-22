package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName WeatherController
 * @Description TODO
 * @Author liu
 * @Date 2018/11/21 9:29
 * @Version 1.0
 **/
@RestController
@Slf4j
//    @Controller
public class WeatherController {
    @Resource
    WeatherService weatherService;

//    @ResponseBody
    @PostMapping("/weather")
    public BaseResponseVo weather(@RequestParam(name = "city") String city){
        //log.info(city);
        String citycode = weatherService.findcitycode(city);
        //log.info(citycode);
        WeatherPo weatherPo = weatherService.Weather(citycode);
        return BaseResponseVo.success();
    }
}