package com.camels.java.util.concurrent.pools;

import com.camels.java.util.concurrent.pools.compute.ComputeService;
import com.camels.java.util.concurrent.pools.compute.ComputeTask;
import com.camels.java.util.concurrent.pools.io.IOService;
import com.camels.java.util.concurrent.pools.io.IOTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Todo 计算型与密集型
 * Created by zhanggc on 2015/1/26.
 */
public class SingleThreadPoolUse {
    public static ExecutorService executor = Executors.newFixedThreadPool(8);
    public static ComputeService computeService = new ComputeService();
    public static IOService ioService = new IOService();

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println("start:"+start);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ComputeTask computeTask = null;
                for(int count=0;count<10;count++){
                    computeTask = new ComputeTask(computeService);
                    executor.execute(computeTask);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                IOTask ioTask = null;
                for(int count=0;count<10;count++){
                    ioTask = new IOTask(ioService);
                    executor.execute(ioTask);
                }
            }
        }).start();

        System.out.println("finish...................");
    }
}
