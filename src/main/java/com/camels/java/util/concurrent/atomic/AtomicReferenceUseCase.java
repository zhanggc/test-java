package com.camels.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Todo {@link java.util.concurrent.atomic.AtomicReference} 使用
 * Created by zhanggc on 2014/10/15.
 */
public class AtomicReferenceUseCase {
    private static AtomicReference<Integer> count;
    static{
        count = new AtomicReference<Integer>(0);
    }

    public static void main(String[] args){
        Integer old = count.get();
        count.compareAndSet(old,old+1);
    }
}
