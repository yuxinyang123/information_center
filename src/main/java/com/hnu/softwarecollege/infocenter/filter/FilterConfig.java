package com.hnu.softwarecollege.infocenter.filter;

import com.hnu.softwarecollege.infocenter.filter.impl.AuthFilter;
import com.hnu.softwarecollege.infocenter.filter.impl.CorsFilter;
import com.hnu.softwarecollege.infocenter.filter.impl.LogFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * @program: infocenter
 * @description: JavaConfig of Filter
 * @author: yu
 * @create: 2018-11-09 03:17
 **/
@Configuration
public class FilterConfig {

    public static final String[] AUTHPATH = {
            "/center/*","/user/info","/user/face","/user/pass","/user/private","/res/*"
    };

    @Bean
    @ConditionalOnProperty(prefix = "server",name = "auth",havingValue = "true")
    public FilterRegistrationBean authFilterRegister(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.setName("authFilter");
        filterRegistrationBean.addUrlPatterns(AUTHPATH);
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean LogFilterRegister(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setName("logFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean CorsFilterRegister(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CorsFilter());
        filterRegistrationBean.setName("corsFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }
}
