package com.hnu.softwarecollege.infocenter.service.impl;

import com.hnu.softwarecollege.infocenter.entity.po.ResTypePo;
import com.hnu.softwarecollege.infocenter.entity.po.ResourcePo;
import com.hnu.softwarecollege.infocenter.entity.vo.ResForm;
import com.hnu.softwarecollege.infocenter.mapper.ResTypePoMapper;
import com.hnu.softwarecollege.infocenter.mapper.ResourcePoMapper;
import com.hnu.softwarecollege.infocenter.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ResourceServiceImpl
 * @Description TODO
 * @Author liu
 * @Date 2018/12/10 9:21
 * @Version 1.0
 **/
@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {
    @Resource
    ResTypePoMapper resTypePoMapper;
    @Resource
    ResourcePoMapper resourcePoMapper;

    /*
     * @Author 刘亚双
     * @Description //TODO 通过帖子类型的名字进行查询，进行两个表连接查询，
     * @Date 2018/12/10 14:48
     * @Param [typename]
     * @return java.util.List<com.hnu.softwarecollege.infocenter.entity.po.ResTypePo>
     **/
    @Override
    public List<ResTypePo> getListByTypeName(String typename) {
        List<ResTypePo> resTypePoList = resTypePoMapper.queryTypeResource(typename);
        return resTypePoList;
    }

    /*
     * @Autor wangzixuan
     * @Description //TODO 插入新的帖子
     * @Date 10:57 2018/12/13
     * @Param [resForm]
     * @return int
    **/
    @Override
    public int insertResForm(ResForm resForm) {
        return 0;
    }

    /*
     * @Author 刘亚双
     * @Description //TODO 通过Id 查询对应的帖子
     * @Date 2018/12/10 14:51
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.po.ResourcePo
     **/
    @Override
    public ResourcePo getResourcePoById(String id) {
        Long resId = Long.parseLong(id);
        ResourcePo resourcePo = resourcePoMapper.selectByPrimaryKey(resId);
        return resourcePo;
    }

    /*
     * @Autor wangzixuan
     * @Description //TODO 通过ID删除相关帖子
     * @Date 10:39 2018/12/13
     * @Param [id]
     * @return int
    **/
    @Override
    public int deleteResourceById(String id) {
        Long resId = Long.parseLong(id);
        int i = resourcePoMapper.deleteByPrimaryKey(resId);
        return i;
    }

    /*
     * @Autor wangzixuan
     * @Description //TODO 通过ID更新信息
     * @Date 10:44 2018/12/13
     * @Param [id]
     * @return int
    **/
    @Override
    public int updateResourceById(String id) {
        return 0;
    }

    /*
     * @Autor wangzixuan
     * @Description //TODO 通过ID删除评论
     * @Date 10:49 2018/12/13
     * @Param [id]
     * @return int
    **/
    @Override
    public int deleteCommentById(String id) {
        return 0;
    }


}
