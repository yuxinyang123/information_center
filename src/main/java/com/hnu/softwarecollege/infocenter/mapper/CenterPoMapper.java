package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CenterPoMapper {
    int deleteByPrimaryKey(Long centerId);

    int insert(CenterPo record);

    int insertSelective(CenterPo record);

    CenterPo selectByPrimaryKey(Long centerId);

    int updateByPrimaryKeySelective(CenterPo record);

    int updateByPrimaryKey(CenterPo record);
}