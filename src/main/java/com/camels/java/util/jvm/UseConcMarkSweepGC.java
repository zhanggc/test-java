package com.camels.java.util.jvm;

/**
 * @Todo 新生代使用并行，老年代使用CMS(Concurrent Mark Sweep)收集器
 *
 * @JAVA_OPTS -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=4 -XX:+PrintGCDetails
 * @Algorithm 标记清除算法
 * @Advantage 注重停顿、非独占式
 * @Weakness 回收内存空间碎片化，导致大对象内存分配时，不连续内存空间工作效率低于连续的内存空间；
 * -XX:+UseConcMarkSweepGC 新生代使用并行收集器，老年代都使用CMS
 * -XX:ParallelGCThreads 新生代线程数量（CPU<8, -XX:ParallelGCThreads=CPU;CPU>8， -XX:ParallelGCThreads=3+[(5*CPU)/8]）
 * -XX:ParallelCMSThreads CMS线程数量
 * Created by zhanggc on 2014/11/25.
 */
public class UseConcMarkSweepGC {
    public static void main(String[] args){

    }
}
