package com.camels.java.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Todo 下限阻塞 {@link java.util.concurrent.CountDownLatch} 使用
 * Created by zhanggc on 2014/10/11.
 */
public class CountDownLatchUseCase {
    final CountDownLatch start = new CountDownLatch(1);
    final CountDownLatch done;
    int workerCount;

    public CountDownLatchUseCase(int workerCount){
        this.workerCount = workerCount;
        done =  new CountDownLatch(workerCount);
    }

    public static void main(String[] args){
        CountDownLatchUseCase useCase = new CountDownLatchUseCase(4);
        useCase.run();
    }

    public void run(){
        for(;workerCount--!=0;){
            new Worker().start();
        }
        start.countDown();
        //do something
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //等待任务完成
        try {
            done.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" all done ...");
    }

     class Worker extends Thread{
        @Override
        public void run() {
            try {
                start.await();
                System.out.println(Thread.currentThread().getName()+" doing work ...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            done.countDown();
            System.out.println(Thread.currentThread().getName()+" done  ...");
        }
    }
}
