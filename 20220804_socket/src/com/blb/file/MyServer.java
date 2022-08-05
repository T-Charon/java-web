package com.blb.file;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author Charon
 * @Date 2022/8/4
 **/
public class MyServer {
    public static final String PATH = "C:\\file\\";

    public void start(){
        //启动服务器
        System.out.println("服务器启动了");
        try (ServerSocket serverSocket = new ServerSocket(9001)){
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("接收到客户端"+socket.getInetAddress());
                //获取文件名
                ObjectInputStream ois= new ObjectInputStream(socket.getInputStream());
                String name = ois.readUTF();
                System.out.println(name);
                //下载文件
                Files.copy(socket.getInputStream(), Paths.get(PATH+name));
                System.out.println("接收完成");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyServer().start();
    }
}
