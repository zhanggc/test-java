package com.camels.java.lang;

/**
 * @Todo 运行时系统参数
 * Created by zhanggc on 2014/11/16.
 */
public class RuntimeParams {

    public static void main(String[] args){
    }

    public static void maxMemory(){
        System.out.println(Runtime.getRuntime().maxMemory());
    }

    public static void totalMemory(){
        System.out.println(Runtime.getRuntime().totalMemory());
    }

    public static void freeMemory(){
        System.out.println(Runtime.getRuntime().freeMemory());
    }
    public static void availableProcessors(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
