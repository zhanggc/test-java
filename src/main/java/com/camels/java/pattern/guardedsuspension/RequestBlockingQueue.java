package com.camels.java.pattern.guardedsuspension;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Todo 请求阻塞队列
 * Created by zhanggc on 2014/11/30.
 */
public class RequestBlockingQueue {
    private BlockingQueue<Request> requestQueue = new LinkedBlockingDeque<Request>();

    //put a request
    public void put(Request request) throws InterruptedException{
        requestQueue.put(request);
    }

    //take a request
    public Request take() throws InterruptedException{
        return requestQueue.take();
    }

    public BlockingQueue<Request> getRequestQueue() {
        return requestQueue;
    }
}
