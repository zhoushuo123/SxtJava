package com.zs.InterWeb.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/**
 * @program: SxtJava
 * @description: 发送端 基本数据类型 ，引用数据类型 ，文件数据类型的接收和发送
 * 中心：就是这些类型文件的序列化和反序列化
 * @author: 周硕
 * @create: 2020-09-18 16:48
 **/
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中。。。");
        //1使用DatagramSocket指定端口，创建发送端
        DatagramSocket Client = new DatagramSocket(6666);
//        准备数据，一定要转成字节数组
        String src = "好好学习，天天向上";
        byte[] data = src.getBytes();
//        封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(data, data.length,
                new InetSocketAddress("localhost", 9999));
//        发送包裹send（DatagramPacket p）
        Client.send(packet);
//        释放资源
        Client.close();
    }
}

