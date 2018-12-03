package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CenterPoMapper {
    int deleteByPrimaryKey(Long centerId);

    int insert(CenterPo record);

    int insertSelective(CenterPo record);

    CenterPo selectByPrimaryKey(Long centerId);

    int updateByPrimaryKeySelective(CenterPo record);

    int updateByPrimaryKey(CenterPo record);

    /*
     * @Author 刘亚双
     * @Description 通过UserKey  来获取CenterId
     * @Date 2018/11/26 14:30
     * @Param [userKey]
     * @return java.lang.Long
     **/

    Long selectByUserKey(Long userKey);
    /*
     * @Author 刘亚双
     * @Description //根据 centerId 修改 centerPo 中的weatherCode
     * @Date 2018/11/26 15:27
     * @Param [centerId]
     * @return int
     **/
    int updateWeatherCodeByPrimaryKey(Integer weatherCode,Long centerId);
}