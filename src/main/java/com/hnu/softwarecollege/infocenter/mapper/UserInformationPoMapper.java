package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.UserInformationPo;

public interface UserInformationPoMapper {
    int deleteByPrimaryKey(Long infId);

    int insert(UserInformationPo record);

    int insertSelective(UserInformationPo record);

    UserInformationPo selectByPrimaryKey(Long infId);

    int updateByPrimaryKeySelective(UserInformationPo record);

    int updateByPrimaryKey(UserInformationPo record);
}