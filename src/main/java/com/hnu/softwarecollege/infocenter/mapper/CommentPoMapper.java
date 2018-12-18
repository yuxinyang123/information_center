package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.CommentPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentPoMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(CommentPo record);

    int insertSelective(CommentPo record);

    CommentPo selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(CommentPo record);

    int updateByPrimaryKeyWithBLOBs(CommentPo record);

    int updateByPrimaryKey(CommentPo record);

    List<CommentPo> selectByEssayKey(Long id);

}