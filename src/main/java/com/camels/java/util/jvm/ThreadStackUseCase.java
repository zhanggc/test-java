package com.camels.java.util.jvm;

/**
 * @Todo 线程栈（属于虚拟机栈）使用测试
 * @JAVA_OPTS -Xss10m -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 * -Xss 设置线程栈大小
 * Jvm支持最大线程数：跟单个线程栈大小与Java heap 大小有关
 * Created by zhanggc on 2014/11/24.
 */
public class ThreadStackUseCase {
    public static void main(String[] args){
        int count =0;
        for(;;count++){
            new TestThread().start();
            System.out.println(count);
        }

    }

    //自定义测试线程类
    public static class TestThread extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(10000);    //保证短时间内不退出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
