package com.blb.tcpsocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Author Charon
 * @Date 2022/8/4
 * 服务端
 **/
public class MyServer {
    public void server(){
        System.out.println("服务器启动了");
        try(ServerSocket serverSocket = new ServerSocket(8888)) {
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("接收到客户端"+socket.getInetAddress());
                try( ObjectInputStream ois= new ObjectInputStream(socket.getInputStream())) {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    String s = ois.readUTF();
                    System.out.println(socket.getInetAddress()+"说："+s);
                    oos.writeUTF("客户端你好"+new Date());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        myServer.server();
    }
}
