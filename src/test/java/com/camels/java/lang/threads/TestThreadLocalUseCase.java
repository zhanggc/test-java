package com.camels.java.lang.threads;

/**
 * @Todo {@link java.lang.ThreadLocal} 使用demo
 * Created by zhanggc on 2014/10/10.
 */
public class TestThreadLocalUseCase {

    public static void main(String[] args){
        final  ThreadLocalUseCase useCase = new ThreadLocalUseCase();
        new Thread(new Runnable() {
            @Override
            public void run() {
                useCase.get();
                useCase.change(Thread.currentThread().getName());
                useCase.println();
            }
        },"Changed").start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                useCase.get();
                useCase.println();
            }
        },"Default").start();
    }
}
