package com.hnu.softwarecollege.infocenter.entity.po;

public class CenterPo {
    private Long centerId;

    private Long userKey;

    private Long degreeKey;

    private Integer weatherCode;

    public CenterPo(Long userKey, Long degreeKey, Integer weatherCode) {
        this.userKey = userKey;
        this.degreeKey = degreeKey;
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

    public Long getDegreeKey() {
        return degreeKey;
    }

    public void setDegreeKey(Long degreeKey) {
        this.degreeKey = degreeKey;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }
}