package com.camels.java.grammar.extend;

/**
 * @Todo 内部类继承特例
 * Created by zhanggc on 2014/10/8.
 */
public class InnerExtendsUseCase extends InnerExtendsUse {
    public InnerClass newInnerClass(){
        return new InnerClass();
    }
}
