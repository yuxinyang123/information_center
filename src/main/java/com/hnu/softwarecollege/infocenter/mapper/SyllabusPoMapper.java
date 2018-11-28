package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;

public interface SyllabusPoMapper {
    int deleteByPrimaryKey(Long syllabusId);

    int insert(SyllabusPo record);

    int insertSelective(SyllabusPo record);

    SyllabusPo selectByPrimaryKey(Long syllabusId);

    int updateByPrimaryKeySelective(SyllabusPo record);

    int updateByPrimaryKey(SyllabusPo record);
}