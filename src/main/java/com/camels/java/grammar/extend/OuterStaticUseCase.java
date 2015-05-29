package com.camels.java.grammar.extend;

/**
 * @Todo 内部静态类提供外部使用特例
 * Created by zhanggc on 2014/10/8.
 */
public class OuterStaticUseCase {

    public OuterStaticUse.OuterClass newOuterClass(){
        return new OuterStaticUse.OuterClass();
    }
}
