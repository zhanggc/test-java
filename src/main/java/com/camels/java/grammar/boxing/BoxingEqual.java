package com.camels.java.grammar.boxing;

/**
 * @Todo 相同字面值的两个封装类 t1、t2,在下面情况地址值也相等（==）
 * -----------------------------------------------------------------
 * If the value p being boxed is true, false, a byte, a char in the range \u0000 to
 * \u007f, or an int or short number between -128 and 127, then let r1 and r2 be
 * the results of any two boxing conversions of p.It is always the case that r1 ==
 * r2.（jls3-5.1.7 Boxing Conversion）
 * ------------------------------------------------------
 * Created by zhanggc on 2014/10/30.
 */
public class BoxingEqual {

    public static void main(String[] args){
        System.out.println(booleanEqual());
        System.out.println(charEqual());
        System.out.println(byteEqual());
        System.out.println(shortEqual());
        System.out.println(intEqual());
    }


    // true or false
    public static boolean booleanEqual(){
        Boolean b1 = true;
        Boolean b2 = true;
        return b1==b2;
    }

    // \u0000 to \u007f
    public static boolean charEqual(){
        Character c1 = '\u0000';
        Character c2 = '\u0000';
        return c1==c2;
    }

    // -128 to 127
    public static boolean byteEqual(){
        Byte b1 = 0;
        Byte b2 = 0;
        return b1==b2;
    }

    // -128 to 127
    public static boolean shortEqual(){
        Short s1 = 0;
        Short s2 = 0;
        return s1==s2;
    }

    // -128 to 127
    public static boolean intEqual(){
        Integer i1 = 0;
        Integer i2 = 0;
        return i1==i2;
    }
}
