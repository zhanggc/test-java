package com.camels.java.pattern.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Todo 食物队列
 * Created by zhanggc on 2014/12/11.
 */
public class FoodBlockingQueue {
    private BlockingQueue<Food> queue = new LinkedBlockingDeque<Food>();

    //put a food
    public void put(Food food) throws InterruptedException{
        queue.put(food);
    }

    //take a food
    public Food take() throws InterruptedException{
        return queue.take();
    }

    public BlockingQueue<Food> getRequestQueue() {
        return queue;
    }
}
