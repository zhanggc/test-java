package com.camels.java.util.jvm;

/**
 * @Todo 新生代使用并行收集器，老年代使用串行回收器
 * @Detail
 *      1. 设置年轻代为并行收集。可与CMS收集同时使用。JDK5.0以上，JVM会根据系统配置自行设置，所以无需再设置此值。
 *      2. 是 UseParallelGC 的 gc 的升级版本，有更好的性能或者优点，可以和 CMS 一起使用。
 * @JAVA_OPTS -XX:+UseParNewGC -XX:+PrintGCDetails
 * -XX:+UseParNewGC 新生代使用并行收集器，老年代都使用串行回收器
 * Created by zhanggc on 2014/11/25.
 */
public class UseParNewGC {

    public static  void main(String[] args){

    }
}

