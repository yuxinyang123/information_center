package com.hnu.softwarecollege.infocenter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.context.CityMapContext;
import com.hnu.softwarecollege.infocenter.entity.po.CityPo;
import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.mapper.WeatherPoMapper;
import com.hnu.softwarecollege.infocenter.service.WeatherService;
import com.hnu.softwarecollege.infocenter.util.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {
    @Resource
    private CityMapContext cityMapContext;
    @Override
    public String findcitycode(String cityname){

        Map<String, CityPo> map = this.cityMapContext.getMap();
        CityPo cp =map.get(cityname);
        return cp.getCity_code();
    }

    @Resource
    private WeatherPoMapper weatherPoMapper;
    @Override
    public WeatherPo Weather(Integer citycode){
        WeatherPo wp = weatherPoMapper.selectByPrimaryKey(citycode);
        if(StringUtils.isEmpty(wp)){
            String str = HttpRequestUtil.getJsonContent(citycode.toString());
            ObjectMapper mapper = new ObjectMapper();
            try {
                WeatherPo weatherPo = mapper.readValue(str,WeatherPo.class);
                insertWeather(weatherPo);
                return weatherPo;
            } catch (IOException e) {
                log.error("json 转换为实体类错误");
            }
        }
        return wp;

    }
    @Override
    public void insertWeather(WeatherPo weatherPo) {
        weatherPoMapper.insert(weatherPo);
    }
}
