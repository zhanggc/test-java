package com.camels.java.util.concurrent;

/**
 * @Todo {@code final} 修饰变量（基本类型、对象、数组） 在实例化时，保证对所有其他线程可见
 * x 可见
 * y 不一定不可见
 * Created by zhanggc on 2014/10/12.
 */
public class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;
    public FinalFieldExample() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
        }
    }
}
