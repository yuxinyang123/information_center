package com.hnu.softwarecollege.infocenter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.ResTypePo;
import com.hnu.softwarecollege.infocenter.entity.po.ResourcePo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.CommentForm;
import com.hnu.softwarecollege.infocenter.entity.vo.CommentVo;
import com.hnu.softwarecollege.infocenter.entity.vo.ResForm;
import com.hnu.softwarecollege.infocenter.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
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
        Integer i = resourceService.deleteResourceById(id);
        if (i != null){
            return BaseResponseVo.success();
        }else {
            return BaseResponseVo.fail("错误，无法删除");
        }
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
     * @Description //TODO 获取文章，
     * @Date 17:04 2018/11/21
     * @Param [id]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @GetMapping("/{essayId}")
    public BaseResponseVo getResource(@PathVariable("essayId") String id){
        ResourcePo resourcePo = resourceService.getResourcePoById(id);
        boolean bool = StringUtils.isEmpty(resourcePo);
        if(bool==true){
            return BaseResponseVo.error("获取信息失败");
        }else {
            return BaseResponseVo.success(resourcePo);
        }
    }

    /**
     * @Author wangzixuan
     * @Description //TODO 添加评论
     * @Date 17:40 2018/11/21
     * @Param [comment]
     * @return com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo
     **/
    @PostMapping("/{id}/comment")
    public BaseResponseVo addComment(@RequestBody CommentForm comment, @PathVariable String id, Errors errors){
        if(errors.hasErrors()) {
            return BaseResponseVo.error("file not null");
        }
        Long userkey = ThreadContext.getUserContext().getUserId();
        int flag = resourceService.addComment(userkey,comment,id);
        if(flag==0){
            return  BaseResponseVo.error("添加失败");
        }else{
            return BaseResponseVo.success("添加成功");
        }
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
        int flag = resourceService.deleteByPrimaryKey(id);
        if(flag==0){
            return BaseResponseVo.error("删除失败");
        }else{
            return BaseResponseVo.success("删除成功");
        }
    }

    /**
     * @Author yuxinyang
     * @Description //TODO 更新评论
     * @Date 17:45 2018/11/21
     * @Param [commentForm, id]获取所有评论
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
    @GetMapping("/{essayId}/comment")
    public BaseResponseVo getAllComments(@RequestParam int pageNum,@RequestParam int pageSize, @PathVariable String essayId){
        PageHelper.startPage(pageNum,pageSize);
        List<CommentVo> poList = resourceService.getAllComment(essayId);
        PageInfo<CommentVo> poPageInfo = new PageInfo<>(poList);
        if(poList.size()==0){
            return BaseResponseVo.error("没有获取到评论数据");
        }else {
            return BaseResponseVo.success(poPageInfo);
        }
    }
}
