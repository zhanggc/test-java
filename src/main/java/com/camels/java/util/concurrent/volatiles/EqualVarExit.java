package com.camels.java.util.concurrent.volatiles;

import java.util.logging.Logger;

/**
 * Created by zhanggc on 2014/8/8.
 */
public class EqualVarExit {
    private static volatile boolean isExist;
    private static long count;
    private static long max;

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for(;;){
                    while(true){
                        count ++;
                        if(tryExit()){
                            break;
                        }
                        //用于记录“成功退出”最大循环数
                        max=max<count?count:max;
                        System.out.println(count);
                    }
                    count = 0;
                    if(System.currentTimeMillis()-start>12000){
                        Logger.getAnonymousLogger().info("Max:"+max);
                        System.exit(0);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    swapValue();
                }
            }
        }).start();
    }

    /**
     * @Todo 尝试退出
     * @Tips 如果在读取变量isExist之后到第二次读取isExist之前，
     * 这段时间内运行swapValue进行更改内存值，表达式：isExist==!isExist
     * 结果将会为false;
     * @return
     */
    public static boolean tryExit(){
        if(isExist==!isExist){
            return true;
        }
        return false;
    }

    /**
     * @Todo 切换内存值
     */
    public static void swapValue(){
        isExist = !isExist;
    }
}
