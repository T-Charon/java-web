package com.blb.udpsoket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author Charon
 * @Date 2022/8/5
 **/
public class UdpServer {
    public static final int PORT = 9999;
    public void start(){

        try(DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("启动服务端");
            while(true){
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                //接受数据
                socket.receive(datagramPacket);
                //输出
                System.out.println(datagramPacket.getAddress()+"说"+new String(datagramPacket.getData(),0,
                        datagramPacket.getLength(),"UTF-8"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UdpServer().start();

    }
}
