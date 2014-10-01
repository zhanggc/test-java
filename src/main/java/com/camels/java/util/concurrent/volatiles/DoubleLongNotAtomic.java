package com.camels.java.util.concurrent.volatiles;

import java.util.Random;
import java.util.logging.Logger;
import java.lang.Thread;

/**
 * @Todo 验证Long类型在Win32环境下 读、写不是原子操作
 * Created by zhanggc on 2014/8/25.
 */
public class DoubleLongNotAtomic {
    private static long threadOneVar;
    private static long threadTwoVar;
    private volatile static long result;
    private volatile static Thread.State threadOneState;
    private volatile static Thread.State threadTwoState;
    private static Random random = new Random();
    static{
        threadOneState = Thread.State.WAITING;
        threadTwoState = Thread.State.WAITING;
    }

    public static void  change(long value) {
        result = value;
    }
    /**
     * @Todo 两个线程设置变量值与结果比较，如果
     * 结果值result不等于任意线程设置值，则发生
     * long类型高低位赋值出错；
     *
     */
    public static void  compare(){
        if(result!=threadOneVar&&result!=threadTwoVar){
            Logger.getAnonymousLogger().info("exception result:"+result);
            Logger.getAnonymousLogger().info("exception threadOneVar:"+threadOneVar);
            Logger.getAnonymousLogger().info("exception threadTwoVar:"+threadTwoVar);
            System.exit(0);
        }else{
            Logger.getAnonymousLogger().info("normal result:"+result);
            Logger.getAnonymousLogger().info("normal threadOneVar:"+threadOneVar);
            Logger.getAnonymousLogger().info("normal threadTwoVar:"+threadTwoVar);
        }
    }

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(Thread.State.WAITING.equals(threadOneState)){
                        threadOneVar = random.nextLong();
                        change(threadOneVar);
                        threadOneState = Thread.State.TERMINATED;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(Thread.State.WAITING.equals(threadTwoState)){
                        threadTwoVar = random.nextLong();
                        change(threadTwoVar);
                        threadTwoState = Thread.State.TERMINATED;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(Thread.State.TERMINATED.equals(threadOneState)&&Thread.State.TERMINATED.equals(threadTwoState)){
                        compare();
                        threadOneState = Thread.State.WAITING;
                        threadTwoState = Thread.State.WAITING;
                    }
                }
            }
        }).start();
    }
}
