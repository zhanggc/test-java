package com.camels.java.util.jvm;

/**
 * @Todo 新生代使用并行，老年代使用串行回收器
 * @Algorithm 复制算法
 * @Advantage 注重 吞吐量
 * @Weakness 独占式
 * @JAVA_OPTS -XX:+UseParallelGC -XX:+PrintGCDetails
 * -XX:+UseParallelGC 新生代使用并行回收收集器，老年代使用串行回收器
 * -XX:ParallelGCThreads 新生代线程数量（CPU<8, -XX:ParallelGCThreads=CPU;CPU>8， -XX:ParallelGCThreads=3+[(5*CPU)/8]）
 * Created by zhanggc on 2014/11/25.
 */
public class UseParallelGC {
    public static void main(String[] args){

    }
}
