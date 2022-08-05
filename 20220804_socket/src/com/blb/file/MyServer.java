package com.blb.file;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Author Charon
 * @Date 2022/8/4
 **/
public class MyServer {
    //启动服务器
    public void start(){
        System.out.println("服务器启动了");
        try (ServerSocket serverSocket = new ServerSocket(8888)){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
