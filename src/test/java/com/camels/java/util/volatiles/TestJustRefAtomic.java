package com.camels.java.util.volatiles;

import com.camels.java.util.concurrent.volatiles.JustRefAtomic;

import java.util.logging.Logger;

/**
 * @Todo {@code volatile} 仅对引用同步
 * Created by zhanggc on 2014/10/12.
 */
public class TestJustRefAtomic {
    private static long count;
    private static long max;

    public static void main(String[] args){
        final JustRefAtomic justRefAtomic =  new JustRefAtomic();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for(;;){
                    while(true){
                        count ++;
                        if(justRefAtomic.unequal()){
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
                    justRefAtomic.swap();
                }
            }
        }).start();
    }
}
