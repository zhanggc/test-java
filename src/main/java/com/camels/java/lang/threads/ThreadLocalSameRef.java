package com.camels.java.lang.threads;

/**
 * @Todo {@link java.lang.ThreadLocal} 设置同一个对象
 * @Confirm 导致所有线程对同一个对象修改
 * Created by zhanggc on 2014/10/10.
 */
public class ThreadLocalSameRef {
    private final ThreadLocalUseCase.SwapValue same;
    private final ThreadLocal<ThreadLocalUseCase.SwapValue> value;
    {
        same = new ThreadLocalUseCase.SwapValue("Default");
        value = new ThreadLocal<ThreadLocalUseCase.SwapValue>();
    }

    //获取
    public ThreadLocalUseCase.SwapValue get(){
        if(null==value.get())
            value.set(same);
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

}
