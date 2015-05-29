package com.camels.java.arithmetic.hash;

/**
 * @Todo 哈希与取模比较
 * @Tips hash算法spend time less mod算法 spend time
 * Created by zhanggc on 2014/11/9.
 */
public class HashModCompare {
    private static int[][] hashDistribution = new int[16][1];
    private static int[][] modDistribution = new int[16][1];

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        hash();
        System.out.println("hash spend :"+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        mod();
        System.out.println("mod spend :"+(System.currentTimeMillis()-start));
    }

    //打印
    public static void print(){
        for(int index=-1;++index<16;){
            System.out.print(index+":"+hashDistribution[index][0]+",");
        }
        System.out.println();
        for(int index=-1;++index<16;){
            System.out.print(index+":"+modDistribution[index][0]+",");
        }
    }

    public static void mod(){
        Mod mod = new Mod((int)Math.pow(2,4));
        Object obj = null;
        int modValue = 0;
        for(int i=0;i++<1000000000;){
            obj = new Object();
            modValue = mod.mod(obj.hashCode());
            modDistribution[modValue][0] = modDistribution[modValue][0]+=1;
        }
    }

    public static void hash(){
        Hash hash = new Hash((int)Math.pow(2,4));
        Object obj = null;
        int hashValue = 0;
        for(int i=0;i++<1000000000;){
            obj = new Object();
            hashValue = hash.hash(obj.hashCode());
            hashDistribution[hashValue][0] = hashDistribution[hashValue][0]+=1;
        }
    }
}
