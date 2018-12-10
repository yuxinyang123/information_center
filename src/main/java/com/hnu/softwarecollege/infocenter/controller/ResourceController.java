package com.hnu.softwarecollege.infocenter.controller;

import com.hnu.softwarecollege.infocenter.entity.po.ResTypePo;
import com.hnu.softwarecollege.infocenter.entity.po.ResourcePo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.CommentForm;
import com.hnu.softwarecollege.infocenter.entity.vo.ResForm;
import com.hnu.softwarecollege.infocenter.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 15:09
 **/
@RestController
@RequestMapping("/res")
@Slf4j
public class ResourceController {
    @Resource
    ResourceService resourceService;
    /**
     * @Author yuxinyang
     * @Description //TODO 根据类型，获取资源列表、（返回标题）
     * @Date 16:50 2018/11/21
     * @Param [type]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/lists")
    public BaseResponseVo getAllResLists(@RequestParam String type){
        List<ResTypePo> resTypePoList = resourceService.getListByTypeName(type);
        if(resTypePoList.size()==0){
            return BaseResponseVo.error("没有查找到！！！！");
        }else {
            return BaseResponseVo.success(resTypePoList);
        }
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 添加资源
     * @Date 17:00 2018/11/21
     * @Param [resForm]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/res")
    public BaseResponseVo addResource(@RequestBody ResForm resForm){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 删除资源
     * @Date 17:03 2018/11/21
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @DeleteMapping("/{id}")
    public BaseResponseVo delResource(@PathVariable("id") String id){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 更新资源
     * @Date 17:04 2018/11/21
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/{id}")
    public BaseResponseVo updateResource(@PathVariable("id") String id){
        return null;
    }


    /**
     * @Author yuxinyang
     * @Description //TODO 获取资源
     * @Date 17:04 2018/11/21
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/{id}")
    public BaseResponseVo getResource(@PathVariable("id") String id){
        ResourcePo resourcePo = resourceService.getResourcePoById(id);
        return BaseResponseVo.success(resourcePo);
    }


    /**
     * @Author yuxinyang
     * @Description //TODO 添加评论
     * @Date 17:40 2018/11/21
     * @Param [comment]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/{id}/comment")
    public BaseResponseVo addComment(@RequestBody CommentForm comment,@PathVariable String id){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 删除评论
     * @Date 17:44 2018/11/21
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @DeleteMapping("/{id}/comment")
    public BaseResponseVo delComment(@PathVariable String id){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 更新评论
     * @Date 17:45 2018/11/21
     * @Param [commentForm, id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PutMapping("/{id}/comment")
    public BaseResponseVo updateComment(@RequestBody CommentForm commentForm,@PathVariable String id){
        return null;
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 获取所有评论
     * @Date 17:46 2018/11/21
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/{id}/comment")
    public BaseResponseVo getAllComments(@PathVariable String id){
        return null;
    }
}
