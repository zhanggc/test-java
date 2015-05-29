package com.camels.java.pattern.guardedsuspension;

/**
 * @Todo 业务请求
 * Created by zhanggc on 2014/11/30.
 */
public class Request {
    //Request name
    private final String name;

    public Request(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
