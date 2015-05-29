package com.camels.java.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Todo 正确发布对象引用(注：创建对象是，保证对象引用对其他线程可见)
 * @Method
 *      1. 通过静态初始化器初始化对象的引用
 *      2. 将它的引用存储到volatile域或AtomicReference
 *      3. 将它的引用存储到正确创建的对象的final域中
 *      4. 将它的引用存储到由锁正确保护的域中
 * Created by zhanggc on 2014/12/6.
 */
public class SafePublish {
    // 通过静态初始化器初始化对象的引用
    static Publisher publisher1 = new Publisher();

    // 将它的引用存储到volatile域
    volatile Publisher publisher2;

    // 将它的引用存储到volatile域
    AtomicReference<Publisher> publisher3;

    // 将它的引用存储到正确创建的对象的final域中
    final Publisher publisher4;
    SafePublish(){
        this.publisher4 = new Publisher();
    }

    // 将它的引用存储到由锁正确保护的域中
    Publisher publisher5;
    public synchronized void set(){
        this.publisher5 = new Publisher();
    }




    //发布对象
    static class Publisher{}
}
