package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.ResTypePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResTypePoMapper {
    int deleteByPrimaryKey(Long typeId);

    int insert(ResTypePo record);

    int insertSelective(ResTypePo record);

    ResTypePo selectByPrimaryKey(Long typeId);

    int updateByPrimaryKeySelective(ResTypePo record);

    int updateByPrimaryKey(ResTypePo record);
}