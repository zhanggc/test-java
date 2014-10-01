/**
 * 项目: test-concurrent
 * 包名：com.camels.concurrent.Threads
 * 文件名: TestJoin
 * 创建时间: 2014/9/28 16:54
 * 支付界科技有限公司版权所有，保留所有权利
 */
package com.camels.java.util.concurrent.threads;

/**
 * @Todo:
 * @Author: Zhanggc
 */
public class TestJoin {
    public static void  main(String[] args) throws InterruptedException {
        final Data data = new Data(0);
        Task task = new Task(data);
        task.start();
        task.join();
        System.out.println(data.getValue());
    }

    static class Task extends Thread{
        private Data data;

        private Task(Data data){
            this.data = data;
        }
        @Override
        public void run() {
            int value = 0;
            long start = System.currentTimeMillis();
            for(;System.currentTimeMillis()-start<5000;){
                value++;
            }
            if(null==data)  data = new Data(value);
            data.setValue(value);
        }
    }

    static class Data{
        private int value;

        public Data(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
