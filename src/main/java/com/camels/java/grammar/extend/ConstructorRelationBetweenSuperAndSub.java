package com.camels.java.grammar.extend;

/**
 * @Todo 父类与子类在构造函数之间关系
 * 1. 如果类里面只有含参数构造函数，则此类失去默认构造函数 {@code new Super()}
 * ,且它的子类必须显式调用父类有参构造函数 {@code public Sub(){super("");}} ;
 * 2. 子类不能继承父类的构造函数；
 * 3. 如果子类显式调用父类有参构造函数，则不会调用父类默认构造函数；
 * 4. 构造函数里面调用构造函数，必须放置该函数首行；
 * Created by zhanggc on 2014/10/20.
 */
public class ConstructorRelationBetweenSuperAndSub {

    static class Super{
        public Super(){
            System.out.println("Super");
        }
        public Super(String value){
            System.out.println("Super value");
        }
    }

    static class Sub extends Super{
        public Sub(){
            super("Sub");
            System.out.println("Sub");
        }
    }

    public static void main(String[] args){
        new Sub();
    }

}
