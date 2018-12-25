package com.hnu.softwarecollege.infocenter.mailtest;

import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.mapper.UserPoMapper;
import com.hnu.softwarecollege.infocenter.service.impl.MailService;
import com.hnu.softwarecollege.infocenter.util.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName Mailtest
 * @Description TODO
 * @Author wang
 * @Date 2018/12/18 15:32
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mailtest {

    @Resource
    private MailService mailService;

    @Resource
    private MailUtil mailUtil;

    @Resource
    private UserPoMapper userPoMapper;

    String to = "798647567@qq.com";
    @Test
    public void sendText(){
        UserPo userPo = userPoMapper.selectByUserEmail("maliu@sina.com");
        String text = mailUtil.createLink(userPo);
        mailService.sendTextMail(to,"找回密码",text);
    }

}
