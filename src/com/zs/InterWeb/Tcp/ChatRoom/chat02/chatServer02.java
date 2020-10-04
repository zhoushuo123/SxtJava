package com.zs.InterWeb.Tcp.ChatRoom.chat02;

import com.zs.InterWeb.Tcp.ChatRoom.ZsUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 服务端，监听客户端 接收
 * 模拟登陆的服务端 多个客户端的访问 多线程
 * 步骤：
 * 1 指定端口，使用 ServerSocket创建服务器
 * 2、阻塞式等待连接
 * 3、操作 输入输出流操作
 * 4、释放资源
 * @author: 周硕
 * @create: 2020-09-20 11:00
 **/
public class chatServer02 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-------");
//  1 指定端口，使用 ServerSocket创建服务器
        ServerSocket Server = new ServerSocket(9999);
//  3、操作 输入输出流操作
        while (true) {
            Socket client = Server.accept();
            System.out.println("建立了一个连接");
            new Thread(new Channel(client)).start();
        }
        //  ZsUtils.close(dis,dos,client);
    }
}


class Channel implements Runnable {
    private Socket client;//套接字 管道
    private DataInputStream dis;//得到的数据流
    private DataOutputStream dos;//发送给客户端的数据流
    boolean isRuning = true;
//    private static byte[] bytes = new byte[1024];
//    private static int len = 1;

    //初始化
    public Channel(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("====(3,4).new====");
            release();
        }
    }

    //实习业务逻辑
    public void run() {
        while (isRuning) {
            String data = rely();
            if (!data.equals("")) {
                send(data);
            }
        }
    }

    //接收数据
    public String rely() {
        String datas = "";
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            System.out.println("3-----接收");
            release();
        }
        return datas;
    }

    //返回客户端信息
    public void send(String msg) {
        try {
            dos.writeUTF(msg);//返回给客户端信息
            dos.flush();
        } catch (IOException e) {
            System.out.println("4-----发送");
            release();
        }
    }

    //释放资源
    public void release() {
        this.isRuning = false;
        ZsUtils.close(dis, dos, client);
    }
}
