package com.zs.InterWeb.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


/**
 * @program: SxtJava
 * @description: 发送端
 * 多线程交流
 * @author: 周硕
 * @create: 2020-09-18 16:48
 **/
public class TalkSend implements Runnable {
    private DatagramSocket Client;////1使用DatagramSocket指定端口，创建发送端
    private DatagramPacket packet;
    private int pron;//端口号
    private String ToIp;
    private int Toprot;
    //

    public TalkSend(int pron,String toip,int Toprot) {
        System.out.println("发送端启动中。。。");
        this.ToIp = toip;
        this.Toprot =Toprot;
        try {
            this.pron = pron;
            this.Client = new DatagramSocket(pron);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    // = new DatagramSocket(6666);
    //

    @Override
    public void run() {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String src = reader.readLine();
                byte[] data = src.getBytes();
//        封装成DatagramPacket包裹，需要指定目的地
                DatagramPacket packet = new DatagramPacket(data, data.length,
                        new InetSocketAddress(ToIp,Toprot ));
//        发送包裹send（DatagramPacket p）
                Client.send(packet);

                if (src.equals("bey")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //        释放资源
        //System.out.println("关闭发送端");
        Client.close();
    }
}