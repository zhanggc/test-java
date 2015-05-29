package com.camels.java.util.collection.stack;

import java.util.Stack;

/**
 * @Todo 栈基本方法用法
 * Created by zhanggc on 2014/11/30.
 */
public class StackUseCase {
    private static final Stack<String> stack = new Stack<String>();

    public static void main(String[] args){

    }

    //push item
    public static void push(String item){
        stack.push(item);
    }

    //pop item and not delete
    public static String pop(){
       return stack.pop();
    }

    //pop item and delete
    public static String peek(){
       return stack.peek();
    }
}
