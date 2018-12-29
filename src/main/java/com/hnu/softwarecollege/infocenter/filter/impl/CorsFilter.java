package com.hnu.softwarecollege.infocenter.filter.impl;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1.http请求头
//
//        Origin: 普通的HTTP请求也会带有，在CORS中专门作为Origin信息供后端比对,表明来源域。
//
//        Access-Control-Request-Method: 接下来请求的方法，例如PUT, DELETE等等
//
//        Access-Control-Request-Headers: 自定义的头部，所有用setRequestHeader方法设置的头部都将会以逗号隔开的形式包含在这个头中
//
//        2.http响应头
//
//        然后浏览器再根据服务器的返回值判断是否发送非简单请求。简单请求前面讲过是直接发送，只是多加一个origin字段表明跨域请求的来源。然后服务器处理完请求之后，会再返回结果中加上如下控制字段
//
//        Access-Control-Allow-Origin: 允许跨域访问的域，可以是一个域的列表，也可以是通配符"*"。这里要注意Origin规则只对域名有效，并不会对子目录有效。即http://foo.example/subdir/ 是无效的。但是不同子域名需要分开设置，这里的规则可以参照同源策略
//
//        Access-Control-Allow-Credentials: 是否允许请求带有验证信息，XMLHttpRequest请求的withCredentials标志设置为true时，认证通过，浏览器才将数据给脚本程序。
//
//        Access-Control-Expose-Headers: 允许脚本访问的返回头，请求成功后，脚本可以在XMLHttpRequest中访问这些头的信息
//
//        Access-Control-Max-Age: 缓存此次请求的秒数。在这个时间范围内，所有同类型的请求都将不再发送预检请求而是直接使用此次返回的头作为判断依据，非常有用，大幅优化请求次数
//
//        Access-Control-Allow-Methods: 允许使用的请求方法，以逗号隔开
//
//        Access-Control-Allow-Headers: 允许自定义的头部，以逗号隔开，大小写不敏感

/**
 * @program: infocenter
 * @description: 跨域访问设置响应头
 * @author: yu
 * @create: 2018-11-09 03:57
 **/
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        //*表示允许所有域名跨域
        httpResponse.addHeader("Access-Control-Allow-Origin", "https://yixiaotong.club");
        httpResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        //允许跨域的Http方法
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        httpResponse.addHeader("Access-Control-Allow-Credentials","true");
        httpResponse.addHeader("Access-Control-Max-Age","3600");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
