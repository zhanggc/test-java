package com.camels.java.util.concurrent.synchronizeds;

/**
 * @Todo {@code synchronized} 禁止修饰构造函数
 * Created by zhanggc on 2014/10/12.
 */
public class ForbidUseInConstructor {

    public static void main(String[] args){
        new ForbidUseInConstructor();
    }
    /*synchronized */ ForbidUseInConstructor(){
        synchronized (this){
            System.out.println("synchronized in constructor");
        }
    }
}
