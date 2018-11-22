package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherPo {
    @JsonProperty("cityId")
    private Integer weatherCode;
    @JsonProperty("city")
    private String weatherCityName;
    @JsonProperty("date")
    private String weatherDate;
    @JsonProperty("sunrise")
    private String weatherSunrise;
    @JsonProperty("high")
    private String weatherHigh;
    @JsonProperty("low")
    private String weatherLow;
    @JsonProperty("sunset")
    private String weatherSunset;
    @JsonProperty("aqi")
    private Float weatherAqi;
    @JsonProperty("notice")
    private String weatherNotice;
    @JsonProperty("type")
    private String weatherType;
    @JsonProperty("fl")
    private String weatherFl;
    @JsonProperty("fx")
    private String weatherFx;

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getWeatherCityName() {
        return weatherCityName;
    }

    public void setWeatherCityName(String weatherCityName) {
        this.weatherCityName = weatherCityName == null ? null : weatherCityName.trim();
    }

    public String getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(String weatherDate) {
        this.weatherDate = weatherDate == null ? null : weatherDate.trim();
    }

    public String getWeatherSunrise() {
        return weatherSunrise;
    }

    public void setWeatherSunrise(String weatherSunrise) {
        this.weatherSunrise = weatherSunrise == null ? null : weatherSunrise.trim();
    }

    public String getWeatherHigh() {
        return weatherHigh;
    }

    public void setWeatherHigh(String weatherHigh) {
        this.weatherHigh = weatherHigh == null ? null : weatherHigh.trim();
    }

    public String getWeatherLow() {
        return weatherLow;
    }

    public void setWeatherLow(String weatherLow) {
        this.weatherLow = weatherLow == null ? null : weatherLow.trim();
    }

    public String getWeatherSunset() {
        return weatherSunset;
    }

    public void setWeatherSunset(String weatherSunset) {
        this.weatherSunset = weatherSunset == null ? null : weatherSunset.trim();
    }

    public Float getWeatherAqi() {
        return weatherAqi;
    }

    public void setWeatherAqi(Float weatherAqi) {
        this.weatherAqi = weatherAqi;
    }

    public String getWeatherNotice() {
        return weatherNotice;
    }

    public void setWeatherNotice(String weatherNotice) {
        this.weatherNotice = weatherNotice == null ? null : weatherNotice.trim();
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType == null ? null : weatherType.trim();
    }

    public String getWeatherFl() {
        return weatherFl;
    }

    public void setWeatherFl(String weatherFl) {
        this.weatherFl = weatherFl == null ? null : weatherFl.trim();
    }

    public String getWeatherFx() {
        return weatherFx;
    }

    public void setWeatherFx(String weatherFx) {
        this.weatherFx = weatherFx == null ? null : weatherFx.trim();
    }
}