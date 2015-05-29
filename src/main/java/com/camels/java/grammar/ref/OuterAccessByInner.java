package com.camels.java.grammar.ref;

/**
 * @Todo 外部类属性通过内部类暴露
 * Created by zhanggc on 2014/10/9.
 */
public class OuterAccessByInner {

    //外部println
    private void println(){
        System.out.println("outer print");
    }

    public InnerClass newInnerClass(){
        return new InnerClass();
    }

    protected class InnerClass{
        //内部println
          void println(){
            //访问this {@link OuterAccessByInner}
            OuterAccessByInner.this.println();
        }
    }
}
