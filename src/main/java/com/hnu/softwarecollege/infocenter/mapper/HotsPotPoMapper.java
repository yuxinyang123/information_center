package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;

public interface HotsPotPoMapper {
    int deleteByPrimaryKey(Integer hotspotId);

    int insert(HotsPotPo record);

    int insertSelective(HotsPotPo record);

    HotsPotPo selectByPrimaryKey(Integer hotspotId);

    int updateByPrimaryKeySelective(HotsPotPo record);

    int updateByPrimaryKey(HotsPotPo record);
}