package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeatherPoMapper {
    int deleteByPrimaryKey(Integer weatherCode);

    int insert(WeatherPo record);

    int insertSelective(WeatherPo record);

    WeatherPo selectByPrimaryKey(Integer weatherCode);

    int updateByPrimaryKeySelective(WeatherPo record);

    int updateByPrimaryKey(WeatherPo record);
}