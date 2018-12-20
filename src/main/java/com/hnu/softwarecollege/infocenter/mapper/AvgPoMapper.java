package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.AvgPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AvgPoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AvgPo record);

    int insertSelective(AvgPo record);

    AvgPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AvgPo record);

    int updateByPrimaryKey(AvgPo record);

    List<AvgPo> findAll();
}