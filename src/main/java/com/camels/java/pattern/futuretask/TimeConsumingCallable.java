package com.camels.java.pattern.futuretask;

import java.util.concurrent.Callable;

/**
 * @Todo 任务调用
 * Created by zhanggc on 2014/12/11.
 */
public class TimeConsumingCallable implements Callable<TimeConsumingResult> {
    @Override
    public TimeConsumingResult call() throws Exception {
        try {
            Thread.sleep(5000); //耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TimeConsumingResult();
    }
}
