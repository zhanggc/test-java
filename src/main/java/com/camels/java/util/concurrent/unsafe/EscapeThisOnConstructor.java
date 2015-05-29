package com.camels.java.util.concurrent.unsafe;

/**
 * @Todo {@code Constroctor} this 指针逃逸
 * Created by zhanggc on 2014/10/14.
 */
public class EscapeThisOnConstructor {
    private final String name;
    static EscapeThisOnConstructor escape;

    EscapeThisOnConstructor(String name){
        escape = this;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                new EscapeThisOnConstructor("Escape");
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    if(null!=escape){
                        System.out.println(escape.name);
                    }
                    if(null!=escape.name){
                        System.out.println(escape.name);
                        break;
                    }
                }
            }
        }).start();
    }

}
