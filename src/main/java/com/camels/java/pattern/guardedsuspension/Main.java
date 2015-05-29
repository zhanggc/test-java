package com.camels.java.pattern.guardedsuspension;

/**
 * @Todo 启动入口
 * Created by zhanggc on 2014/11/30.
 */
public class Main {

    public static void main(String[] args){
        RequestBlockingQueue requestQueue = new RequestBlockingQueue();
        int count = 4;
        for(int i =0;i<count;i++){
            new Client(requestQueue,"thread-client-"+i).start();
        }
        for(int i =0;i<count;i++){
            new Server(requestQueue,"thread-server-"+i).start();
        }
    }

}
