package com.camels.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Todo 对象内部元素引用原子更新
 * Created by zhanggc on 2014/10/15.
 */
public class AtomicReferenceFieldUpdaterUseCase {
    String name;
    private volatile AtomicReferenceFieldUpdaterUseCase updaterField;
    private static AtomicReferenceFieldUpdater<AtomicReferenceFieldUpdaterUseCase,AtomicReferenceFieldUpdaterUseCase> fieldUpdater;

    static{
        fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(AtomicReferenceFieldUpdaterUseCase.class,AtomicReferenceFieldUpdaterUseCase.class,"updaterField");
    }

    private AtomicReferenceFieldUpdaterUseCase(String name){
        this.name = name;
    }

    public static void main(String[] args){
        AtomicReferenceFieldUpdaterUseCase parent = new AtomicReferenceFieldUpdaterUseCase("parent");
        fieldUpdater.set(parent,new AtomicReferenceFieldUpdaterUseCase("child"));
        System.out.println(fieldUpdater.get(parent).getName());
    }

    public String getName() {
        return name;
    }
}
