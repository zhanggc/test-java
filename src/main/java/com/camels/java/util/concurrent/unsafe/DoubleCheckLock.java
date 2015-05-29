package com.camels.java.util.concurrent.unsafe;

/**
 * @Todo 双重检查 {@link java.util.concurrent.locks.Lock}
 * @Reason 重排序(invokespecial与putstatic互换)
 * @NEW BYTE CODE STRUCTURE {@code singleInstance = new SingleInstance();}
 *    20:	new	#6; //class com/camels/java/util/concurrent/unsafe/DoubleCheckLock$SingleInstance
 *    23:	dup
 *    24:	invokespecial	#7; //Method "<init>":()V
 *    27:	putstatic	#5; //Field singleInstance:Lcom/camels/java/util/concurrent/unsafe/DoubleCheckLock$SingleInstance;
 * Created by zhanggc on 2014/10/16.
 */
public class DoubleCheckLock {
    public static void main(String[] args) {
        SingleInstance singleInstance = SingleInstance.getInstance();
    }

    static class SingleInstance {
        int val2;
        volatile int val1;
        final int val3;
        static SingleInstance singleInstance;

        private SingleInstance() {
            val1 = 9;
            val2 = 10;
            val3 = 11;
        }

        static SingleInstance getInstance() {
            if(null==singleInstance){
                synchronized (SingleInstance.class){
                    if(null==singleInstance)
                        singleInstance = new SingleInstance();
                }
            }
            return singleInstance;
        }
    }
}
