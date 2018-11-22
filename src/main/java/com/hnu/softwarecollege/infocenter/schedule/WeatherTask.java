package com.hnu.softwarecollege.infocenter.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.mapper.WeatherPoMapper;
import com.hnu.softwarecollege.infocenter.util.HttpRequestUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName WeatherTask
 * @Description 定时任务
 * @Author liu
 * @Date 2018/11/22 10:29
 * @Version 1.0
 **/


@Configuration
@EnableScheduling
public class WeatherTask {
    @Resource
    WeatherPoMapper weatherPoMapper;
    @Scheduled(cron="0 0 7,15,23 * * ?")
    public void MyTask() throws IOException {
        List<WeatherPo> weatherPoList= weatherPoMapper.findAll();
        for(WeatherPo weatherPo:weatherPoList){
            int code = weatherPo.getWeatherCode();
            String citycode = code+"";
            String str = HttpRequestUtil.getJsonContent(citycode);
            ObjectMapper mapper = new ObjectMapper();
            WeatherPo weather = mapper.readValue(str,WeatherPo.class);
            weatherPoMapper.updateByPrimaryKey(weather);
        }
    }
}
