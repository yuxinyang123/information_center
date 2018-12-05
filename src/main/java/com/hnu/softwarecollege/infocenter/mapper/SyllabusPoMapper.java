package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SyllabusPoMapper {
    int deleteByPrimaryKey(Long syllabusId);

    int insert(SyllabusPo record);

    int insertSelective(SyllabusPo record);

    SyllabusPo selectByPrimaryKey(Long syllabusId);

    int updateByPrimaryKeySelective(SyllabusPo record);

    int updateByPrimaryKey(SyllabusPo record);

    List<SyllabusPo> findAllByUserKey(Long userkey);
}