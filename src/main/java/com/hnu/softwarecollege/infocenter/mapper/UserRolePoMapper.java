package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.UserRolePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRolePoMapper {
    int deleteByPrimaryKey(Long urId);

    int insert(UserRolePo record);

    int insertSelective(UserRolePo record);

    UserRolePo selectByPrimaryKey(Long urId);

    int updateByPrimaryKeySelective(UserRolePo record);

    int updateByPrimaryKey(UserRolePo record);
}