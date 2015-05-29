package com.camels.java.util.concurrent.unsafe;

/**
 * @Todo 不同线程修改 byte数组相邻元素，将导致 线程不安全 (处理器不能对数组中其中一个元素作修改，而是当整体修改)
 * Created by zhanggc on 2014/10/17.
 */
public class WordTearing extends Thread{
    static final int LENGTH = 8;
    static final int ITERS = 1000000000;
    static byte[] counts = new byte[LENGTH];

    static Thread[] threads = new Thread[LENGTH];
    final int id;
    WordTearing(int i) {
        id = i;
    }
    public void run() {
        byte v = 0;
        for (int i = 0;; i++) {
            byte v2 = counts[id];
            if (v != v2) {
                System.err.println("Word-Tearing found: " +
                        "counts[" + id
                        + "] = " + v2 + ", should be " + v);
                return;
            }
            v++;
            counts[id] = v;
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < LENGTH; ++i)
            (threads[i] = new WordTearing(i)).start();
    }
}
