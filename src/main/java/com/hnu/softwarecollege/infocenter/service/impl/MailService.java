package com.hnu.softwarecollege.infocenter.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName MailService
 * @Description TODO
 * @Author wang
 * @Date 2018/12/18 15:50
 * @Version 1.0
 **/

@Service
@Slf4j
public class MailService {

//    @Value("${spring.mail.username}")
//    private String from;

    @Resource
    private JavaMailSenderImpl javaMailSender;

    /**
     * 发送文本邮件
     */
    public void sendTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // 发送对象
        message.setSubject(subject); // 邮件主题
        message.setText(content); // 邮件内容
        message.setFrom("gujiarena@163.com"); // 邮件的发起者

        javaMailSender.send(message);
    }

}
