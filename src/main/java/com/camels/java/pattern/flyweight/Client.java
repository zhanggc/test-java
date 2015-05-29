package com.camels.java.pattern.flyweight;

/**
 * @Todo 客户端
 * Created by zhanggc on 2014/10/23.
 */
public class Client {

    public static void main(String[] args){
        ServiceFactory factory = ServiceFactory.newFactory();
        IService taskService = factory.getService(TaskService.class);
        IService fianceService = factory.getService(FianceService.class);
    }
}
