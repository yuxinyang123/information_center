package com.hnu.softwarecollege.infocenter.forumTest;

import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.controller.ResourceController;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.entity.vo.BaseResponseVo;
import com.hnu.softwarecollege.infocenter.entity.vo.CommentForm;
import com.hnu.softwarecollege.infocenter.mapper.WeatherPoMapper;
import com.hnu.softwarecollege.infocenter.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName forumTest
 * @Description TODO
 * @Author liu
 * @Date 2018/12/18 17:44
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class forumTest {
    @Resource
    ResourceService resourceService;
    @Resource
    ResourceController resourceController;
    @Resource
    WeatherPoMapper weatherPoMapper;
    @Before
    public void createUser(){
        UserPo userPo = new UserPo(1l,"liuyashuang","liuyashuang@sina.com",
                "13017894556","liuyashuang","1");
        ThreadContext.setUserContext(userPo);
    }
    @Test
    public void addCommentTest(){
        CommentForm commentForm = new CommentForm();
        commentForm.setCommentContext("感觉楼主！！！");
//        BaseResponseVo baseResponseVo =resourceController.addComment(commentForm,"1");
//        System.out.println(baseResponseVo);

    }

    @Test
    public void deleteComment(){
        BaseResponseVo baseResponseVo = resourceController.delComment("1");
        System.out.println(baseResponseVo);
    }

    @Test
    public void getAllComment(){
        BaseResponseVo baseResponseVo = resourceController.getAllComments(1,3,"1");
        System.out.println(baseResponseVo);
    }

    @Test
    public void updateWeather(){
        WeatherPo weatherPo = new WeatherPo(101090101,"石家庄","19日星期三",
                "07:13","高温 15.0℃","低温 2.0℃","8",
                "17:04",240f,"阴晴之间，谨防紫外线侵扰",
                "多云","<3级","西风");

        int num = weatherPoMapper.updateByPrimaryKeySelective(weatherPo);
        System.out.println(num);

    }
}
