package com.blb.file.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

/**
 * 客户端
 * @author Charon
 */
public class ClientTest {

    public static void main(String[] args) {
        ClientTest clientTest = new ClientTest();

    }

    public  ClientTest(){
        try {
            Socket socket = new Socket("192.168.31.72", 8888);
            //向服务端写入数据（开启自动刷新缓存）
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            //控制台输入需要发送的数据
            InputStreamReader isr1 = new InputStreamReader(System.in);
            //将需要发送的数据存入缓存中
            BufferedReader br1 = new BufferedReader(isr1);

            //接收服务端的信息
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            //存入缓存
            BufferedReader br = new BufferedReader(isr);

            while (true){
                System.out.println("我说:");
                //读取服务端缓存的数据
                String s2 = br1.readLine();
                //将信息传给客户端
                pw.println(s2);
                //读取服务端的数据
                String s1 = br.readLine();
                System.out.println("服务端说："+s1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

