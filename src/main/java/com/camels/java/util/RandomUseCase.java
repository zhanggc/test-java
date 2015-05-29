package com.camels.java.util;

import java.util.Random;

/**
 * @Todo {@link java.util.Random} 使用
 * Created by zhanggc on 2014/11/9.
 */
public class RandomUseCase {

    public static  void main(String[] args){
        //Constructor args（seed） 参与随机数产生过程
        //不同seed 将产生不同随机数（注意：非指产生随机数区间）
        Random random = new Random(10);
        for(;;)
            System.out.println(randomLong(random));
    }

    /**
     * @Todo 产生int随机数
     * @param random
     * @param scope 区间范围：[0,scope)
     * @return
     */
    public static int randomInt(Random random,int scope){
        return random.nextInt(scope);
    }

    /**
     * @Todo 产生int随机数
     * @Tips scope:[-(int)Math.pow(2,31),(int)Math.pow(2,31)-1 )
     * @param random
     * @return
     */
    public static int randomInt(Random random){
        return random.nextInt();
    }

    //产生long随机数
    //scope:[-(long)Math.pow(2,63),(long)Math.pow(2,63)-1 )
    public static long randomLong(Random random){
            return random.nextLong();
    }

    //产生float随机数
    //scope:[0.0,1.0 )
    public static float randomFloat(Random random){
            return random.nextFloat();
    }

    //产生double随机数
    //scope:[0.0,1.0 )
    public static double randomDouble(Random random){
            return random.nextDouble();
    }

    //产生boolean随机数
    //scope:[false,true]
    public static boolean randomBoolean(Random random){
            return random.nextBoolean();
    }


}
