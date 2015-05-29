package com.camels.java.util.concurrent.synchronizeds;

/**
 * @Todo {@code synchronized} 基本语义
 * @Semantics
 * 1) 线程对监视器内部的变量读、写，就是直接对主存的变量读、写：
 *      1. 线程对监视器内的变量的写，保证在该监视器内的其他线程对该已写变量可见
 *      2. 线程对监视器内的变量的写, 不保证在该监视器外的其他线程对该已写变量可见
 *      3. 线程对监视器外的变量的写，不保证在监视器内的其他线程对该已写变量可见
 * 2) 线程间对监视器竞争造成阻塞（BLOCKED）,保证线程在临界区串行执行
 * 3) 不保证监视器内部代码有序性(@see volatile)
 * 4) happen-before monitor rule
 *      • An unlock on a monitor happens-before every subsequent lock on that monitor
 * 5) happen-before synchronized rule
 *      • If an action x synchronizes-with a following action y, then we also have hb(x,y)
 *
 * Created by zhanggc on 2014/12/4.
 */
public class SynchronizedSemantics {
    private static boolean visiable;



}
