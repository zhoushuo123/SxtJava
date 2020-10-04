package com.zs.InterWeb.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: SxtJava
 * @description: 接收端
 * @author: 周硕
 * @create: 2020-09-18 16:49
 **/
public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动中。。。");
        //1使用DatagramSocket指定端口，创建发送端
        DatagramSocket Server = new DatagramSocket(9999);
//        准备数字节数组
        while (true) {
            byte[] container = new byte[1024 * 60];
//        封装成DatagramPacket包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
//        阻塞式接收包裹receive（DatagramPacket p）
            Server.receive(packet);
//        释放资源
            /**
             byte[] datas = packet.getData();
             int len = packet.getLength();
             System.out.println(new String(datas, 0, len));**/
            String data = new String(container);
            System.out.println(data);
            if(data.equals("bye")){
                break;
            }
        }
        Server.close();
    }
}
