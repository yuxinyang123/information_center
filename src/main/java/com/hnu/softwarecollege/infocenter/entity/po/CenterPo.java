package com.hnu.softwarecollege.infocenter.entity.po;

public class CenterPo {
    private Long centerId;

    private Long userKey;

    private Integer weatherCode;

    public CenterPo() {
    }

    public CenterPo(Long userKey, Integer weatherCode) {
        this.userKey = userKey;
        this.weatherCode = weatherCode;
    }

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public Long getUserKey() {
        return userKey;
    }

    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }
}