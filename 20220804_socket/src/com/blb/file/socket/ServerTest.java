package com.blb.file.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Charon
 * @Date 2022/8/5
 **/
public class ServerTest {
    public static void main(String[] args) {
        ServerTest serverTest = new ServerTest();

    }

    public  ServerTest(){
        try {
            //初始ServerSocket
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("=====服务端开启=====");
            //开启监听
            Socket socket = serverSocket.accept();

            //服务端接入，开始读取信息
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            //存入缓存
            BufferedReader br = new BufferedReader(isr);
            //向客户端写入数据（开启自动刷新缓存）
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            //控制台输入需要发送的数据
            InputStreamReader isr1 = new InputStreamReader(System.in);
            //将需要发送的数据存入缓存中
            BufferedReader br1 = new BufferedReader(isr1);

            while (true){
                //读取客户端的数据
                String s1 = br.readLine();
                System.out.println("客户端说："+s1);
                System.out.println("我说:");
                String s2 = br1.readLine();
                //将信息传给客户端
                pw.println(s2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
