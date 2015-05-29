package com.camels.java.pattern.futuretask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Todo 程序入口
 * Created by zhanggc on 2014/12/11.
 */
public class Main {

    public static void main(String[] args)throws Exception{
        //线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //耗时任务
        TimeConsumingTask task = new TimeConsumingTask(new TimeConsumingCallable());
        //执行任务
        executor.execute(task);

        //做其他事情
        doSomething();

        //获取结果
        Result result = task.get();

        System.out.println(result);

        //关闭线程池
        executor.shutdown();

    }

    //做其他事情
    public static void doSomething(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
