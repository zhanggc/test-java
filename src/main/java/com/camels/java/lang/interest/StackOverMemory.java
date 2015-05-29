package com.camels.java.lang.interest;

/**
 * @Todo {@code memorry} 爆炸;)
 * Created by zhanggc on 2014/10/14.
 */
public class StackOverMemory {
    private StackOverMemory stackOverMemory;

    public static void main(String[] args){
        new StackOverMemory();
    }
    private StackOverMemory(){
        stackOverMemory = new StackOverMemory();
    }
}
