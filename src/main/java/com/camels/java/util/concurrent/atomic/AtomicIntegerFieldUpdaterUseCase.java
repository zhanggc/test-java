package com.camels.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by zhanggc on 2014/10/15.
 */
public class AtomicIntegerFieldUpdaterUseCase {
    private volatile int value;
    private static AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterUseCase.class,"value");

    public static void main(String[] args){
        AtomicIntegerFieldUpdaterUseCase useCase = new AtomicIntegerFieldUpdaterUseCase();
        fieldUpdater.addAndGet(useCase,10);
        System.out.println(fieldUpdater.get(useCase));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
