package com.camels.java.util.concurrent.volatiles;


import com.camels.java.util.concurrent.pools.simpler.ThreadPool;

import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Todo 验证线程重排序
 * Created by zhanggc on 2014/9/13.
 */
public class UnorderedExecute {
    private  volatile boolean initialized;
    private  volatile Map<String,String> config;
    private volatile boolean open = true;

    public static void main(String[] args){
        ThreadPool pool = ThreadPool.newFixedThreadPool(5);
        final UnorderedExecute execute = new UnorderedExecute();
        for(;;){
            if(execute.isOpen()){
                execute.setOpen(false);
                pool.execute(new Task(execute));
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        execute.init();
                    }
                });
            }
        }
    }

    public void read(){
        long start = System.currentTimeMillis();
        for(;;){
            System.out.println(Thread.currentThread().getName()+"-"+System.currentTimeMillis()+"read:"+initialized);
            if(initialized){
                if(config==null||config.size()<10){
                    System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+":"+"config is able null"+(config==null?"":",size :"+config.size()));
                    System.exit(0);
                }else{
                    for(String key:config.keySet()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "size:" + config.size() + key + ":" + config.get(key));
                        } catch (Exception e) {
                            Logger.getAnonymousLogger().info("config is "+config);
                            e.printStackTrace();
                        }
                    }
                }
                break;
            }
            //并发导致initialized 不一致
            if(System.currentTimeMillis()-start>8000) break;
        }
    }

    public synchronized void doConfig(){
        //config = ConstantsLoader.getPropertys();
        config = new Hashtable<String, String>();
        for(int i=0;i<10;i++){
            config.put("key" + i, "value" + i);
        }
        System.out.println(Thread.currentThread().getName()+"-"+System.currentTimeMillis()+"doConfig finish! size:"+config.size());
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public synchronized void  setConfig(Map<String, String> config) {
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() +"set config null");
        this.config = config;
    }

    public void init(){
        long start = System.currentTimeMillis();
        //ConstantsLoader.init(ConstantsLoader.Path.APPPATH);
        doConfig();
        initialized = true;
        System.out.println(Thread.currentThread().getName()+"-"+System.currentTimeMillis()+"init:"+initialized);
    }

    public static class Task implements Runnable{

        public UnorderedExecute execute;
        public Task(UnorderedExecute execute){
            this.execute = execute;
        }

        @Override
        public void run() {
            execute.read();
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "read finish!");
            execute.setConfig(null);
            execute.setInitialized(false);
            execute.setOpen(true);
        }
    }
}
