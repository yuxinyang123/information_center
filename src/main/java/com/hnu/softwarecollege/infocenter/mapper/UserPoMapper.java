package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.RolePo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserPoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

    UserPo selectByUserName(@Param("name")String name);
}