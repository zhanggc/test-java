package com.camels.java.util.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Todo 队列基本方法用法
 * Created by zhanggc on 2014/11/30.
 */
public class QueueUseCase {
    private final static Queue<String> queue = new LinkedList<String> ();

    public static  void main(String[] args){

    }

    //offer element
    public static void offer(String element){
         queue.offer(element);
    }

    //poll element
    public static String poll(){
        return queue.poll();
    }

    //peek element
    public static String peek(){
        return queue.peek();
    }


}
