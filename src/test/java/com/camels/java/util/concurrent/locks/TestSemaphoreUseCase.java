package com.camels.java.util.concurrent.locks;

/**
 * @Todo 信号量 {@link java.util.concurrent.Semaphore} 使用
 * @Tips
 *
 * Created by zhanggc on 2014/10/9.
 */
public class TestSemaphoreUseCase {

        public static void main(String[] args){
            final SemaphoreUseCase useCase =  new SemaphoreUseCase(3);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(;;)
                            useCase.take();
                    }
                },"take").start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(;;)
                            useCase.release();
                    }
                },"release").start();
        }
}
