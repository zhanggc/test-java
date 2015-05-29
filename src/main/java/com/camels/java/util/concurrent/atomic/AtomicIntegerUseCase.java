package com.camels.java.util.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Todo {@link java.util.concurrent.atomic.AtomicInteger} 使用
 * Created by zhanggc on 2014/10/12.
 */
public class AtomicIntegerUseCase {
    private  int notAtomic;
    private final AtomicInteger atomic;
    {
        notAtomic = 0;
        atomic = new AtomicInteger(0);
    }

    public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(4);
        final AtomicIntegerUseCase useCase = new AtomicIntegerUseCase();
        for(int i=4;i>0;i--){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int count =4000;
                    for(;count--!=0;){
                        useCase.increment();
                    }
                    latch.countDown();
                }
            }).start();
        }

        try {
            Thread.sleep(10000);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("not atomic :"+useCase.notAtomic);
        System.out.println("atomic :"+useCase.atomic.get());

    }

    public void increment(){
        notAtomic++;
        atomic.getAndIncrement();
    }
}
