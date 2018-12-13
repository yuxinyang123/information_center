package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.ResTypePo;
import com.hnu.softwarecollege.infocenter.entity.po.ResourcePo;
import com.hnu.softwarecollege.infocenter.entity.vo.ResForm;

import java.util.List;

public interface ResourceService {
    public List<ResTypePo> getListByTypeName(String typename);

    public int insertResForm(ResForm resForm);

    public ResourcePo getResourcePoById(String id);

    /*
     * @Autor wangzixuan
     * @Description //TODO 通过ID删除信息
     * @Date 10:47 2018/12/13
     * @Param [id]
     * @return int
    **/
    public int deleteResourceById(String id);

    /*
     * @Autor wangzixuan
     * @Description //TODO 通过ID更新资源
     * @Date 10:59 2018/12/13
     * @Param [id]
     * @return int
    **/
    public int updateResourceById(String id);

    /*
     * @Autor wangzixuan
     * @Description //TODO 通过ID删除评论
     * @Date 10:48 2018/12/13
     * @Param [id]
     * @return int
    **/
    public int deleteCommentById(String id);
}
