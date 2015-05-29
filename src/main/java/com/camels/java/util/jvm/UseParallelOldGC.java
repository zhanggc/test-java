package com.camels.java.util.jvm;

/**
 * @Todo 新生代与老年代并行回收收集器
 * @JAVA_OPTS -XX:+UseParallelOldGC -XX:ParallelGCThreads=4 -XX:+PrintGCDetails
 * @Algorithm 标记压缩算法
 * @Weakness 独占式
 * @Advantage 注重 吞吐量
 * -XX:+UseParallelOldGC 新生代与老年代并行回收收集器
 * -XX:ParallelGCThreads 新生代线程数量（CPU<8, -XX:ParallelGCThreads=CPU;CPU>8， -XX:ParallelGCThreads=3+[(5*CPU)/8]）
 * -XX:MaxGCPauseMillis 设置每次年轻代垃圾回收的最长时间，如果无法满足此时间，JVM会自动调整年轻代大小，以满足此值。
 * -XX:GCTimeRatio 设置吞吐量大小（假设：-XX:GCTimeRatio=n,则用于垃圾回收时间不能超过1/(1+n),默认值n=99）
 * -XX:+UseAdaptiveSizePolicy 打开自适应GC策略(设置此选项后，并行收集器会自动选择年轻代区大小和相应的Survivor区比例，以达到目标系统规定的最低相应时间或者收集频率等，此值建议使用并行收集器时，一直打开。),(与并行收集器（UseParNewGC、UseConcMarkSweepGC）不同之处)
 * Created by zhanggc on 2014/11/25.
 */
public class UseParallelOldGC {
    public static void main(String[] args){

    }
}
