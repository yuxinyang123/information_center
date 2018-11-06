package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.PremissionPo;

public interface PremissionPoMapper {
    int deleteByPrimaryKey(Long prmsId);

    int insert(PremissionPo record);

    int insertSelective(PremissionPo record);

    PremissionPo selectByPrimaryKey(Long prmsId);

    int updateByPrimaryKeySelective(PremissionPo record);

    int updateByPrimaryKey(PremissionPo record);
}