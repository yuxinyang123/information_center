package com.hnu.softwarecollege.infocenter.schedule;

import com.hnu.softwarecollege.infocenter.service.WeatherService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * @ClassName WeatherTask
 * @Description 定时执行任务 修改数据库中的天气数据
 * @Author liu
 * @Date 2018/11/22 10:29
 * @Version 1.0
 **/


@Configuration
@EnableScheduling
public class WeatherTask {
    @Resource
    WeatherService weatherService;
    @Scheduled(cron="0 0/10 0/8 * * ?")
    public void MyTask(){
        weatherService.updateAllWeatherInfo();
    }
}