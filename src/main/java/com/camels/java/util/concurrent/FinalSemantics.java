package com.camels.java.util.concurrent;

/**
 * @Todo {@code final} 基本语义
 * @Semantics
 * 1) 初始化安全性：
 *      1.保证对象正确构造之后，构造函数中设置final 字段值，在所有线程中可见；
 *      2.保证设置一个final 字段引用一个对象(like FinalSemantics.obj)的final 字段(like FinalSemantics.obj.field)值，在所有线程中可见；
 *      3.保证构造函数中 final字段的写 不与后面的操作重排；
 *
 * Created by zhanggc on 2014/12/4.
 */
public class FinalSemantics {
    private final boolean visiable;
    private final Obj obj;

    public FinalSemantics(){
        visiable = true;
        obj = new Obj();//obj.field 对所有线程可见
    }

    class Obj{
        private final int field;

        Obj(){
            this.field = 1;
        }
    }
}
