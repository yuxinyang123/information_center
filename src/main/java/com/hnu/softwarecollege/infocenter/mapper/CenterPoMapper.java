package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;

public interface CenterPoMapper {
    int deleteByPrimaryKey(Long centerId);

    int insert(CenterPo record);

    int insertSelective(CenterPo record);

    CenterPo selectByPrimaryKey(Long centerId);

    int updateByPrimaryKeySelective(CenterPo record);

    int updateByPrimaryKey(CenterPo record);
}