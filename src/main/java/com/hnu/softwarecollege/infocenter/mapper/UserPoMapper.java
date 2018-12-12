package com.hnu.softwarecollege.infocenter.mapper;

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

    /**
    * @Description:  通过姓名查询用户
    * @Param: [name]
    * @return: com.hnu.softwarecollege.infocenter.entity.po.UserPo
    * @Author: yu
    * @Date: 2018/11/8 11:15
    **/
    UserPo selectByUserName(@Param("name")String name);

    UserPo selectByUserEmail(@Param("email")String email);

    /**
    * @Description:  通过所有条件查询用户
    * @Param: [record]
    * @return: com.hnu.softwarecollege.infocenter.entity.po.UserPo
    * @Author: yu
    * @Date: 2018/11/8 11:16
    **/
    UserPo selectByUserSelective(UserPo record);
    /**
     * @Author 刘亚双
     * @Description //通过userkey修改用户密码
     * @Date 2018/12/12 16:23
     * @Param [newpass]
     * @return int
     **/
    int updatePasswordByPrimaryKeySelective(Long userkey,String newpass);
}