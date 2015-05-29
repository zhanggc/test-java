package com.camels.java.util.jvm;

/**
 * @Todo G1收集器/Garbage First(注：jdk1.7+(include 1.7))
 * @JAVA_OPTS -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions
 * @Advantage 控制 吞吐量与停顿 平衡
 * -XX:MaxGCPauseMillis Sets a target for the maximum GC pause time. This is a soft goal, and the JVM will make its best effort to achieve it.
 * -XX:GCPauseIntervalMillis
 * -XX:+UnlockExperimentalVMOptions
 *  Created by zhanggc on 2014/12/16.
 */
public class G1GC {
}
