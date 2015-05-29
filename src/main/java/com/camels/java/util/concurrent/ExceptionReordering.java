package com.camels.java.util.concurrent;

/**
 * @Todo 为保证as-if-serial语义，Java异常处理机制也会为重排序做一些特殊处理。例如在下面的代码中，y = 0 / 0可能会被重排序在x = 2之前执行，为了保证最终不致于输出x = 1的错误结果，JIT在重排序时会在catch语句中插入错误代偿代码，将x赋值为2，将程序恢复到发生异常时应有的状态。这种做法的确将异常捕捉的逻辑变得复杂了，但是JIT的优化的原则是，尽力优化正常运行下的代码逻辑，哪怕以catch块逻辑变得复杂为代价，毕竟，进入catch块内是一种“异常”情况的表现
 * @url http://tech.meituan.com/java-memory-reordering.html
 * Created by zhanggc on 2015/1/10.
 */
public class ExceptionReordering {
    public static void main(String[] args) {
        int x, y;
        x = 1;
        try {
            x = 2;
            y = 0 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("x = " + x);
        }
    }
}
