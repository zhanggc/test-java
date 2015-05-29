package com.camels.java.arithmetic.hash;

/**
 * @Todo 取模
 * Created by zhanggc on 2014/11/9.
 */
public class Mod {
    private int length;
    Mod(int length){
        this.length = length;
    }

    //取模
    public int mod(int dest){
        return dest%length;
    }
}
