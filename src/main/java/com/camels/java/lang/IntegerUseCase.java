package com.camels.java.lang;

import junit.framework.Assert;

/**
 * @Todo  列举 {@link java.lang.Integer} 一些重要方法
 * Created by zhanggc on 2014/11/9.
 */
public class IntegerUseCase {

    public static void main(String[] args){
        int value = parseRadix("10010",2);
        Assert.assertEquals(18,value);
    }


    /**
     * @Todo 其他进制与十进制转换
     * @param str
     * @param radix 基数 2-二进制、8-八进制 等待
     * @return
     */
    public static int parseRadix(String str,int radix){
        return Integer.parseInt(str,radix);
    }
}
