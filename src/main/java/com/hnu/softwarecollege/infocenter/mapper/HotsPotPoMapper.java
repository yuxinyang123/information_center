package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotsPotPoMapper {
    int deleteByPrimaryKey(Integer hotspotId);

    int insert(HotsPotPo record);

    int insertSelective(HotsPotPo record);

    HotsPotPo selectByPrimaryKey(Integer hotspotId);

    int updateByPrimaryKeySelective(HotsPotPo record);

    int updateByPrimaryKey(HotsPotPo record);

    /*
     * @Autor wang
     * @Description //TODO 无条件查询所有热搜数据
     * @Date 16:54 2018/12/5
     * @Param []
     * @return com.github.pagehelper.Page<com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo>
    **/
    List<HotsPotPo> selectAll();
//    @Select("select * from tbl_hotspot")
//    public Page<HotsPotPo> findAll();
}