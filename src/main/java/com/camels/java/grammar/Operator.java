package com.camels.java.grammar;

import org.junit.Assert;

/**
 * @Todo 运算符使用
 * Created by zhanggc on 2014/11/4.
 */
public class Operator {

    public static void main(String[] args){
        threeOperator();
    }


    /**
     * @Todo &(与)运算
     * @Tips 当相同位同时为1时，结果为1；否则为0
     */
    public static void and(){
        int r = 3&4;
        Assert.assertEquals(0,r);
    }

    /**
     * @Todo |（或）运算
     * @Tips 当相同位上任意一边为1，结果为1；相同位上都为0时，结果为0
     */
    public static void or(){
        int r = 3|4;
        Assert.assertEquals(7,r);
    }

    /**
     * @Todo ~（非）运算
     */
    public static void not(){
        int r = ~1;
        Assert.assertEquals(0,r);
    }

    /**
     * @Todo ^(异或)运算
     * @Tips 当相同位上不同时，结果为1；否则为0
     */
    public static void xor(){
        int r = 0^4;
        Assert.assertEquals(4,r);
    }

    /**
     * @Todo 三目运算
     * @Tips 需要三个操作数
     */
    public static void threeOperator(){
        boolean b = true?true:false;
        Assert.assertEquals(true,b);
        int i = 0;
        i+=2;
        Assert.assertEquals(2,i);
        int j = 0;
        j&=2;
        Assert.assertEquals(0,j);
        int k = 0;
        k|=2;
        Assert.assertEquals(2,k);
        int l = 0;
        l^=2;
        Assert.assertEquals(2,l);
        int m = 1;
        m<<=2;
        Assert.assertEquals(4,m);
        int n = -1;
        n>>=2;
        Assert.assertEquals(-1,n);
        int o = -1;
        o>>>=2;
        Assert.assertEquals(((int)Math.pow(2,30))-1,o);
    }

    /**
     * @Todo 取余运算
     */
    public static void remainder(){
        int remainder = 8%3;
        Assert.assertEquals(2,remainder);
    }


    /**
     * @Todo 取模运算
     */
    public static void module(){
    }

    /**
     * @Todo 移位运算
     * @Tips 移动每个周期之后重新回到原来数值；
     * 正整数表示方法：0000 0000 0000 0000 0000 0000 0000 0001 (数值：1) - 0111 1111 1111 1111 1111 1111 1111 1111 （数值：Math.pow(2,31)-1）
     * 负整数表示方法：1111 1111 1111 1111 1111 1111 1111 1111 (数值：-1) - 1000 0000 0000 0000 0000 0000 0000 0000 (数值：-Math.pow(2,31))
     * 零表示方法：0000 0000 0000 0000 0000 0000 0000 0000 (数值：0)
     */
    public static void move(){
        //左移位: 左边移出（舍弃），右边的空位补零.
        int left = 10<<2;
        Assert.assertEquals(10*(2*2),left);
        //右移位：右边移出（舍弃），左边的空位补符号位，即正数补零，负数补1.
        int right = 10>>2;
        Assert.assertEquals(10/(2*2),right);
        //无符号右移位：右边移出（舍弃），左边的空位补零.
        int right_no = 10>>>2;
        Assert.assertEquals(10/(2*2),right_no);
    }
}
