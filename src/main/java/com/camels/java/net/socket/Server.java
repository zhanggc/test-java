package com.camels.java.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by zhanggc on 2014/9/15.
 */
public class Server {
    private static final int port = 91;
    private static ExecutorService executor;
    public static void main(String[] args){
        ServerSocket server = null;
        Socket socket = null;
        executor = Executors.newFixedThreadPool(5);
        try {
            server = new ServerSocket(91);
            while(true){
                socket = server.accept();
                executor.execute(new Task(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                server.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            executor.shutdown();
        }
    }


    public static class Task implements Runnable{

        private Socket socket;
        public Task(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try{
                out = new PrintWriter(socket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //输入
                {
                    StringBuffer sb = new StringBuffer();
                    String line;
                    line=in.readLine();
                    //for(String line="";null!=(line=in.readLine());){  //in.close 导致 socket close
                        sb.append(line);
                    //}
                    Logger.getAnonymousLogger().info(sb.toString());
                }

                //输出
                {
                    out.println("server data ...");
                    out.flush();
                }
                in.close(); //iin.close() 导致 socket close
                out.close(); //in.close() 导致 socket close
            }catch (IOException e){
                e.printStackTrace();
                if(null!=out)   out.close();
                try {
                    if(null!=in) in.close();
                    if(null!=socket) socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }








}
