package com.camels.java.util.concurrent.pools;

import com.camels.java.util.concurrent.pools.compute.ComputeService;
import com.camels.java.util.concurrent.pools.compute.ComputeTask;
import com.camels.java.util.concurrent.pools.io.IOService;
import com.camels.java.util.concurrent.pools.io.IOTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Todo 多种类型线程池
 * Created by zhanggc on 2015/1/26.
 */
public class MultiThreadPoolUse {
    public static ExecutorService computeExecutor = Executors.newFixedThreadPool(4);
    public static ExecutorService ioExecutor = Executors.newFixedThreadPool(16);
    public static ComputeService computeService = new ComputeService();
    public static IOService ioService = new IOService();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("start:" + start);
        Thread computeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ComputeTask computeTask = null;
                for (int count = 0; count < 10; count++) {
                    computeTask = new ComputeTask(computeService);
                    computeExecutor.execute(computeTask);
                }
            }
        });computeThread.start();

        Thread ioThread = new Thread(new Runnable() {
            @Override
            public void run() {
                IOTask ioTask = null;
                for (int count = 0; count < 10; count++) {
                    ioTask = new IOTask(ioService);
                    ioExecutor.execute(ioTask);
                }
            }
        });ioThread.start();
        try {
            computeThread.join();
            ioThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("finish...................");
    }
}