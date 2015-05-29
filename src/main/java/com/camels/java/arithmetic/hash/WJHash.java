package com.camels.java.arithmetic.hash;

/**
 * @Todo Wang/Jenkins 哈希算法
 * Created by zhanggc on 2014/11/10.
 */
public class WJHash {
    //原始数值
    static int hash1 = Integer.parseInt("001111");
    static int hash2 = Integer.parseInt("011111");
    static int hash3 = Integer.parseInt("101111");
    static int hash4 = Integer.parseInt("111111");

    public static void main(String[] args){
        noHash();
        wjHash();
    }


    //Wang/Jenkins 哈希
    private static int hash(int h) {
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3); h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }


    //{@link ConcurrentHashMap} 分段锁应用
    private static void noHash(){
        //取模操作
        int position1 = hash1&(16-1);
        int position2 = hash2&(16-1);
        int position3 = hash3&(16-1);
        int position4 = hash4&(16-1);
        System.out.print(position1+",");
        System.out.print(position2+",");
        System.out.print(position3+",");
        System.out.println(position4);
    }

    //{@link ConcurrentHashMap} 分段锁应用
    //Wang/Jenkins 哈希之后值进行取模将分布在不同位置上
    private static void wjHash(){
        //取模操作
        int position1 = hash(hash1)&(16-1);
        int position2 = hash(hash2)&(16-1);
        int position3 = hash(hash3)&(16-1);
        int position4 = hash(hash4)&(16-1);
        System.out.print(position1+",");
        System.out.print(position2+",");
        System.out.print(position3+",");
        System.out.print(position4);
    }



}
