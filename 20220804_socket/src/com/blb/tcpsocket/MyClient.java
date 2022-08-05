package com.blb.tcpsocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author Charon
 * @Date 2022/8/4
 * 客户端
 **/
public class MyClient {
    public void connect(String ip,int port,String msg){
        try ( Socket socket = new Socket(ip, port);
              ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
              ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());){
            outputStream.writeUTF(msg);
            outputStream.flush();
            String s = inputStream.readUTF();
            System.out.println("服务端说："+s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        MyClient myClient = new MyClient();
        myClient.connect("192.168.110.20",8888,"守护");
    }
}
