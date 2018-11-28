package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;

public interface CenterDegreePoMapper {
    int deleteByPrimaryKey(Long degreeId);

    int insert(CenterDegreePo record);

    int insertSelective(CenterDegreePo record);

    CenterDegreePo selectByPrimaryKey(Long degreeId);

    int updateByPrimaryKeySelective(CenterDegreePo record);

    int updateByPrimaryKey(CenterDegreePo record);
}