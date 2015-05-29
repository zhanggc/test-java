package com.camels.java.pattern.producerconsumer;

import com.camels.java.pattern.guardedsuspension.Client;
import com.camels.java.pattern.guardedsuspension.RequestBlockingQueue;
import com.camels.java.pattern.guardedsuspension.Server;

/**
 * @Todo 程序入口
 * Created by zhanggc on 2014/12/11.
 */
public class Main {

    public static void main(String[] args){
        //food queue
        FoodBlockingQueue queue = new FoodBlockingQueue();
        int count = 4;
        for(int i =0;i<count;i++){
            //new producer
            new Producer(queue,"thread-producer-"+i).start();
        }
        for(int i =0;i<count;i++){
            //new consumer
            new Consumer(queue,"thread-consumer-"+i).start();
        }
    }
}
