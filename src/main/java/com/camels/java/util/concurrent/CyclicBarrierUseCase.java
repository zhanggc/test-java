/**
 * 项目: test-concurrent
 * 包名：com.camels.concurrent.Threads
 * 文件名: CyclicBarrierUseCase
 * 创建时间: 2014/9/28 17:58
 * 支付界科技有限公司版权所有，保留所有权利
 */
package com.camels.java.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

/**
 * @Todo: 上限阻塞 {@link java.util.concurrent.CyclicBarrier} 使用
 * @Author: Zhanggc
 */
public class CyclicBarrierUseCase {

    public static void main(String[] args){
        final CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(new Runnable(){

            @Override
            public void run() {
                Logger.getAnonymousLogger().info("sleeping ...");
                try {
                    Thread.sleep(13000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    barrier.await();
                    Logger.getAnonymousLogger().info("do job  ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable(){

            @Override
            public void run() {
                Logger.getAnonymousLogger().info("waiting ...");
                try {
                    barrier.await();
                    Logger.getAnonymousLogger().info("do job  ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
