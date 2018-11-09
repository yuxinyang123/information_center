package com.hnu.softwarecollege.infocenter.context;

import com.hnu.softwarecollege.infocenter.entity.po.UserPo;

/**
 * @program: infocenter
 * @description: ThreadContext by localThread，每次请求都是一个线程，
 *               将用户放在线程上下文中
 * @author: yu
 * @create: 2018-11-08 10:46
 **/
public class ThreadContext {
    private static ThreadLocal<UserPo> userContext=new ThreadLocal();

    public static UserPo getUserContext() {
        return userContext.get();
    }

    public static void setUserContext(UserPo userPo) {
        userContext.set(userPo);
    }
}
