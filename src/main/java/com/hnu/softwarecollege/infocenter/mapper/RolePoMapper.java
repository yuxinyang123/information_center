package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.RolePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RolePoMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    RolePo selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);


}