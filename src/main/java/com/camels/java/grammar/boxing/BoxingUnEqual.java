package com.camels.java.grammar.boxing;

import com.camels.java.pattern.proxy.delayload.*;

import java.lang.System;

/**
 * @Todo 相同字面值的两个封装类 t1、t2,在下面情况地址值不相等（！=）
 * -----------------------------------------------------------------
 * If the value p being boxed is a byte, a char in the range \u0080 to
 * \uffff, or an int or short number between up 128(contained) or long、float、double, then let r1 and r2 be
 * the results of any two boxing conversions of p.It is always the case that r1 !=
 * r2.
 * ------------------------------------------------------
 * Created by zhanggc on 2014/10/30.
 */
public class BoxingUnEqual {

    public static void main(String[] args){
        System.out.println(doubleUnEqual());
        System.out.println(floatUnEqual());
        System.out.println(charUnEqual());
        System.out.println(shortUnEqual());
        System.out.println(intUnEqual());
    }

    // any
    public static boolean doubleUnEqual(){
        Double d1 = 0d;
        Double d2 = 0d;
        return d1==d2;
    }

    // any
    public static boolean floatUnEqual(){
        Float f1 = 0f;
        Float f2 = 0f;
        return f1==f2;
    }

    // \u0080 to \uffff
    public static boolean charUnEqual(){
        Character c1 = '\u0080';
        Character c2 = '\u0080';
        return c1==c2;
    }

    // 128 up(contained)
    public static boolean shortUnEqual(){
        Short s1 = 128;
        Short s2 = 128;
        return s1==s2;
    }

    //  128 up(contained)
    public static boolean intUnEqual(){
        Integer i1 = 128;
        Integer i2 = 128;
        return i1==i2;
    }
}
