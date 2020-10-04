package com.zs.InterWeb.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: SxtJava
 * @description: 接收端
 * @author: 周硕
 * @create: 2020-09-18 16:49
 **/
public class TalkReceive implements Runnable {
    private DatagramSocket Server;//创建接收端
    private DatagramPacket packet;//封装成DatagramPacke
    private String from;
    private int prot;

    public TalkReceive(int prot, String from) {
        System.out.println("接收端启动。。。。");
        this.from = from;
        try {
            this.prot = prot;
            Server = new DatagramSocket(prot);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] container = new byte[1024 * 60];
//        封装成DatagramPacket包裹，需要指定目的地
                packet = new DatagramPacket(container, 0, container.length);
//        阻塞式接收包裹receive（DatagramPacket p）
                Server.receive(packet);
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas,0,len);
                System.out.println(from + ":" + data);
                if (data.equals("bey")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //        释放资源
        //System.out.println("关闭接收端");
        Server.close();
    }
}

