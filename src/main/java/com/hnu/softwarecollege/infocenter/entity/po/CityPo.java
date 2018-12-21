package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityPo {

    private String city_code;
    private String city_name;

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "CityPo{" +
                "city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
