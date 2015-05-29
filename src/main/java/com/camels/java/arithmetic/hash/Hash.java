package com.camels.java.arithmetic.hash;

import junit.framework.Assert;

/**
 * @Todo hash 算法
 * @Define 是一种将任意内容的输入转换成固定长度输出的加密方式，其输出被称为哈希值。
 * Created by zhanggc on 2014/11/8.
 */
public class Hash {
    int length;//短二进制数值,2的幂次方，利用空间最大

    public Hash(int length){
        this.length = length;
    }

    //计算hash值
    public int hash(int dest){
        return dest & (length-1);
    }

    public static void main(String[] args){
        Hash hash = new Hash((int)Math.pow(2,5));
        int hashValue = hash.hash(48);
        Assert.assertEquals((int)Math.pow(2,4),hashValue);
    }
}
