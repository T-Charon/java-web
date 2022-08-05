package com.blb.udpsoket;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author Charon
 * @Date 2022/8/5
 **/
public class UdpClient {
    public void sendMsg(String ip,int port,String msg){
        try( DatagramSocket socket = new DatagramSocket()) {
            byte[] bytes = msg.getBytes("UTF-8");
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ip), port);
            //发送数据
            socket.send(packet);
            System.out.println("发送完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new UdpClient().sendMsg("192.168.110.27",4399,"露出鸡脚");
        }

    }
}
