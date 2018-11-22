package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;

public interface WeatherService {
    public String findcitycode(String cityname);
    public WeatherPo Weather(String citycode);
    public void insertWeather(WeatherPo weatherPo);

}
