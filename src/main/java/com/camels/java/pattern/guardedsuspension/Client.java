package com.camels.java.pattern.guardedsuspension;

import java.util.Random;

/**
 * @Todo 客户端，负责发送请求 {@linkplain com.camels.java.pattern.guardedsuspension.Request}
 * Created by zhanggc on 2014/11/30.
 */
public class Client extends Thread {
    //request queue
    private final RequestBlockingQueue requestQueue;

    public Client(RequestBlockingQueue requestQueue,String name){
        this.requestQueue = requestQueue;
        this.setName(name);
    }

    @Override
    public void run(){
        Random random = new Random();
        String currentThreadName = Thread.currentThread().getName();
        while(true){
            Request request = null;
            try {
                request = new Request(currentThreadName+"-request-"+random.nextInt());
                requestQueue.put(request);
                println(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void println(Request request){
        System.out.println(Thread.currentThread().getName()+" put:"+request.getName());
    }
}
