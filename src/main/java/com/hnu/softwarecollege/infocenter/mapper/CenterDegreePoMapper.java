package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CenterDegreePoMapper {
    int deleteByPrimaryKey(Long degreeId);

    int insert(CenterDegreePo record);

    int insertSelective(CenterDegreePo record);

    CenterDegreePo selectByPrimaryKey(Long degreeId);

    int updateByPrimaryKeySelective(CenterDegreePo record);

    int updateByPrimaryKey(CenterDegreePo record);

    List<CenterDegreePo> findAllByUserKey(Long userkey);

    List<CenterDegreePo> findAllofUserKey(Long userkey);

    List<CenterDegreePo> selectByClassname(String classname);
}