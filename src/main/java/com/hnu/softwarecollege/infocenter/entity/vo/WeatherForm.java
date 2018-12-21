package com.hnu.softwarecollege.infocenter.entity.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 10:55
 **/
public class WeatherForm {
    @NotEmpty
    private String cityname;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
