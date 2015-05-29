package com.camels.java.lang.interest;

import org.junit.Assert;

/**
 * @Todo 计算符号
 * Created by zhanggc on 2014/11/11.
 */
public class ComputeSign {

    public static void main(String[] args){
        // l>0
        Assert.assertEquals(1,computeLong(100l));
        // l<0
        Assert.assertEquals(-1,computeLong(-100l));
        // l==0
        Assert.assertEquals(0,computeLong(0l));
    }

    public static int computeLong(long l){
        return (int) ( l>>63 | -l>>>63);
    }
}
