package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;

public interface WeatherService {
    public int getcitycode();
    public String findcitycode(String cityname);
    public int updateWeatherInfo(String code);
    public WeatherPo Weather(String citycode);
    public void insertWeather(WeatherPo weatherPo);

}
