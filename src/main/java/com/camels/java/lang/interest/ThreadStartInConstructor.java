package com.camels.java.lang.interest;

/**
 * @Todo 在构造函数里面启动线程
 * Created by zhanggc on 2014/10/12.
 */
public class ThreadStartInConstructor extends Thread{

    public static void main(String[] args){
        new ThreadStartInConstructor();
    }
    ThreadStartInConstructor(){
        start();
    }

    @Override
    public void run() {
        System.out.print("run...");
    }
}
