package com.camels.java.util.collection.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Todo 双端队（尾部与头部都可以存取）列基本方法用法
 * Created by zhanggc on 2014/11/30.
 */
public class DequeUseCase {
    private static final Deque<String> deque = new LinkedList<String>();

    public static void main(String[] args){

    }

    //offer element in tail
    public static void offer(String element){
        deque.offer(element);
    }

    //offer element in head
    public static void offerFirst(String element){
        deque.offerFirst(element);
    }

    //poll element in head
    public static String poll(){
        return deque.poll();
    }

    //poll element in tail
    public static String pollLast(){
        return deque.pollLast();
    }

    //peek element in head
    public static String peek(){
        return deque.peek();
    }

    //peek element in tail
    public static String peekLast(){
        return deque.peekLast();
    }
}
