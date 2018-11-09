package com.hnu.softwarecollege.infocenter.filter.impl;

import com.hnu.softwarecollege.infocenter.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: infocenter
 * @description: 身份验证Filter
 * @author: yu
 * @create: 2018-11-09 03:55
 **/
@Slf4j
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        Cookie token=null;
        if (cookies==null){
            log.info("doesn't have cookies,request url:{}",request.getRequestURI());
            return;
        }
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                token=cookie;
            }
        }
        if(token!=null){
            // there set a userContext
            TokenUtil.VerifyToken(token.getValue());
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            log.info("the token doesn't in cookies,request url:{} ",request.getRequestURI());
        }

    }

    @Override
    public void destroy() {

    }
}
