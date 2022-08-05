package com.blb.file;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author Charon
 * @Date 2022/8/4
 **/
public class MyClient {
    public static final String PATH = "C:\\f\\456.txt";
    public void connect(String ip,int port){
        try (Socket socket = new Socket(ip, port);
             OutputStream out = socket.getOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(out);) {
            //获取文件名
            File file = new File(PATH);
           //传文件名
            outputStream.writeUTF(file.getName());
            //刷新缓存
            outputStream.flush();
            Files.copy(Paths.get(PATH),out);
            System.out.println("发送成功");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyClient().connect("192.168.110.24",9001);
    }
}
