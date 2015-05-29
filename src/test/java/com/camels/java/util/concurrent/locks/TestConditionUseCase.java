package com.camels.java.util.concurrent.locks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Todo 介绍 {@link java.util.concurrent.locks.Condition} 使用
 * Tips
 * Created by zhanggc on 2014/10/9.
 */
public class TestConditionUseCase {
    private static AtomicInteger cusor = new AtomicInteger(0);
    public static void main(String[] args){
        final ConditionUseCase<Integer> useCase = new ConditionUseCase<Integer>(10000000);
        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(;;){
                        int count = cusor.incrementAndGet();
//                        System.out.println("product "+count);
                        useCase.put(count);
                    }
                }
            },"producer").start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(;;){
                        int count = useCase.take();
//                        System.out.println("consume "+count);
                    }
                }
            },"consumer").start();
        }


        for(;;)
            System.out.println("size: "+useCase.size());
    }
}
