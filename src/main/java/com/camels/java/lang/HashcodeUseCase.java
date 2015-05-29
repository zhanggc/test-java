package com.camels.java.lang;

/**
 * Created by zhanggc on 2014/11/3.
 */
public class HashcodeUseCase extends Object{

    public static void main(String[] args){
        long hash1 = new Integer(1).hashCode();
        long hash2 = new Integer(1).hashCode();
        System.out.println(hash1);
        System.out.println(hash2);
    }

}
