package com.camels.java.lang.threads;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @Todo {@link java.lang.ThreadLocal} 使用demo
 * Created by zhanggc on 2014/10/10.
 */
public class ThreadLocalUseCase {
    private final ThreadLocal<SwapValue> value;
    {
        value = new ThreadLocal<SwapValue>();
    }

    //获取
    public SwapValue get(){
        if(null==value.get())
            value.set(new SwapValue("Default"));
        return value.get();
    }

    //改变
    public void change(Object value){
        this.value.get().setValue(value);
    }

    //打印
    public void println(){
        System.out.println(Thread.currentThread().getName()+"："+this.value.get().getValue());
    }

    public static class SwapValue<T>{
        private T value;

        SwapValue(T value){
            this.value = value;
        }
        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

}
