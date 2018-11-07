package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.ResourcePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourcePoMapper {
    int deleteByPrimaryKey(Long resId);

    int insert(ResourcePo record);

    int insertSelective(ResourcePo record);

    ResourcePo selectByPrimaryKey(Long resId);

    int updateByPrimaryKeySelective(ResourcePo record);

    int updateByPrimaryKeyWithBLOBs(ResourcePo record);

    int updateByPrimaryKey(ResourcePo record);
}