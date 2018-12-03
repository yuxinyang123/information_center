package com.hnu.softwarecollege.infocenter.schedutask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName schedudemo
 * @Description TODO
 * @Author wang
 * @Date 2018/12/3 9:51
 * @Version 1.0
 **/


public class schedudemo {
    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        service.scheduleAtFixedRate(runnable,0,10, TimeUnit.SECONDS);
        //service.schedule(runnable,long delay,TimeUnit.MILLISECONDS);
    }
}
