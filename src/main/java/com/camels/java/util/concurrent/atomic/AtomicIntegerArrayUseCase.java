package com.camels.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Todo 原子操作整形数组元素
 * Created by zhanggc on 2014/10/15.
 */
public class AtomicIntegerArrayUseCase {
    private static AtomicIntegerArray atomicIntegerArray;
    static{
        atomicIntegerArray = new AtomicIntegerArray(5);
    }

    public static void main(String[] args){
        atomicIntegerArray.addAndGet(1,10);
        atomicIntegerArray.getAndIncrement(4);
        System.out.print(atomicIntegerArray.get(1));
    }
}
