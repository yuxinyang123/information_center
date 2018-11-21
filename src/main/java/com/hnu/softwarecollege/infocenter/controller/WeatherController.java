package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName WeatherController
 * @Description TODO
 * @Author liu
 * @Date 2018/11/21 9:29
 * @Version 1.0
 **/
//@RestController
    @Controller
public class WeatherController {
    @Resource
    WeatherService weatherService;

//    @ResponseBody
    @RequestMapping("/weather")
    public BaseResponseVo weather(@RequestParam(name = "city") String city){
        String citycode = weatherService.findcitycode(city);
        int it = Integer.valueOf(citycode);
        WeatherPo weatherPo = weatherService.Weather(it);
        return BaseResponseVo.success();
    }
}
