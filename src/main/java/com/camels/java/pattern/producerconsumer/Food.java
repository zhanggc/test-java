package com.camels.java.pattern.producerconsumer;

/**
 * @Todo 食物
 * Created by zhanggc on 2014/12/11.
 */
public class Food {
    //Food name
    private final String name;

    public Food(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
