package com.camels.java.lang.threads;

/**
 * @Todo 测试 {@linkplain Thread#yield()} 使用
 * @tips 让线程重执行状态回到可执行状态/{@linkplain java.lang.Thread.State#RUNNABLE}
 * Created by zhanggc on 2015/1/10.
 */
public class ThreadYield {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                Thread.yield();
                System.out.println("time:"+(System.currentTimeMillis()-start));
            }
        }).start();
    }
}
