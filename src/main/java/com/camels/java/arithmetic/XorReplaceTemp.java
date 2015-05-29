package com.camels.java.arithmetic;


import org.junit.Assert;

/**
 * @Todo ^(异或)运算符 代替临时交换变量
 * Created by zhanggc on 2014/11/4.
 */
public class XorReplaceTemp {
    public static void main(String[] args){
        int a=108,b=204;
        b=b^a;
        a=b^a;
        b=b^a;
        Assert.assertEquals(108, b);
        Assert.assertEquals(204,a);
    }
}
