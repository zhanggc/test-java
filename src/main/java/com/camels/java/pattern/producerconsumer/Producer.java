package com.camels.java.pattern.producerconsumer;

import com.camels.java.pattern.guardedsuspension.Request;

import java.util.Random;

/**
 * Created by zhanggc on 2014/12/11.
 */
public class Producer extends Thread {
    //food queue
    private volatile FoodBlockingQueue queue;

    public Producer(FoodBlockingQueue queue,String threadName){
        super(threadName);
        this.queue = queue;
    }
    @Override
    public void run() {
        Random random = new Random();
        String currentThreadName = Thread.currentThread().getName();
        while(true){
            Food food = null;
            try {
                food = new Food(currentThreadName+"-food-"+random.nextInt());
                queue.put(food);
                println(food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // print food info
    public void println(Food food){
        System.out.println(Thread.currentThread().getName()+" put:"+food.getName());
    }
}
