package com.camels.java.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by zhanggc on 2014/9/15.
 */
public class Client {
    private final static String url ="127.0.0.1";
    private final static int port = 91;
    public static void main(String[] args){
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket(url,port);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //输出
            {
                out.println("client data ...");
                out.flush();
            }

            //输入
            {
                StringBuffer sb = new StringBuffer();
                String line;
                line=in.readLine();
                //for(String line="";null!=(line=in.readLine());){
                sb.append(line);
                //}
                Logger.getAnonymousLogger().info(sb.toString());
            }
            in.close(); //iin.close() 导致 socket close
            out.close(); //in.close() 导致 socket close
            socket.close();
        } catch (IOException e) {
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
