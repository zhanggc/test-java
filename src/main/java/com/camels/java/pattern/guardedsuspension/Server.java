package com.camels.java.pattern.guardedsuspension;

/**
 * @Todo 服务端，获取请求
 * Created by zhanggc on 2014/11/30.
 */
public class Server extends Thread {
    //request queue
    private final RequestBlockingQueue requestQueue;

    public Server(RequestBlockingQueue requestQueue,String name){
        this.requestQueue = requestQueue;
        this.setName(name);
    }

    @Override
    public void run() {
        while(true){
            Request request = null;
            try {
                request = requestQueue.take();
                println(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //print request
    public void println(Request request){
        System.out.println(Thread.currentThread().getName()+" take:"+request.getName());
    }
}
