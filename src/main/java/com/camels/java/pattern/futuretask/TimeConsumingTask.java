package com.camels.java.pattern.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Todo 耗时任务
 * Created by zhanggc on 2014/12/11.
 */
public class TimeConsumingTask extends FutureTask<TimeConsumingResult>{

    public TimeConsumingTask(Callable<TimeConsumingResult> callable){
        super(callable);
    }

}
