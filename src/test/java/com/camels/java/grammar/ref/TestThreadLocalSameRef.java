package com.camels.java.grammar.ref;

import com.camels.java.lang.threads.ThreadLocalSameRef;
import com.camels.java.lang.threads.ThreadLocalUseCase;

/**
 * @Todo {@link java.lang.ThreadLocal} 设置同一个对象
 * @Confirm 导致所有线程对同一个对象修改
 * Created by zhanggc on 2014/10/10.
 */
public class TestThreadLocalSameRef {
    public static void main(String[] args){
        final ThreadLocalSameRef useCase = new ThreadLocalSameRef();
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
