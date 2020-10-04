package com.zs.InterWeb.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;


/**
 * @program: SxtJava
 * @description: 发送端
 * 多线程交流
 * @author: 周硕
 * @create: 2020-09-18 16:48
 **/
public class UdpTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中。。。");
        //1使用DatagramSocket指定端口，创建发送端
        DatagramSocket Client = new DatagramSocket(6666);
//        准备数据，一定要转成字节数组
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String src = reader.readLine();
            byte[] data = src.getBytes();
//        封装成DatagramPacket包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(data, data.length,
                    new InetSocketAddress("localhost", 9999));
//        发送包裹send（DatagramPacket p）
            Client.send(packet);
            if (src.equals("bye")){
                break;
            }
        }
//        释放资源
        Client.close();
    }
}

