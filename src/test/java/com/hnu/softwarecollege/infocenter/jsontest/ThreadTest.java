package com.hnu.softwarecollege.infocenter.jsontest;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author liu
 * @Date 2018/12/5 16:25
 * @Version 1.0
 **/
public class ThreadTest {
    public static void main(String arg[]){
        ThreadTest threadTest = new ThreadTest();
        MyThread myThread = threadTest.new MyThread();
        MyThread myThread1 = threadTest.new MyThread();
        myThread.start();
        myThread1.start();
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            for(int i =0;i<10;i++){
                System.out.println(i);
            }
        }
    }
}
