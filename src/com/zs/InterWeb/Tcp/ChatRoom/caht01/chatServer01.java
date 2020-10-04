package com.zs.InterWeb.Tcp.ChatRoom.caht01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 服务端，监听客户端 接收
 * 步骤：
 * 1 指定端口，使用 ServerSocket创建服务器
 * 2、阻塞式等待连接
 * 3、操作 输入输出流操作
 * 4、释放资源
 * @author: 周硕
 * @create: 2020-09-20 11:00
 **/
public class chatServer01 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-------");
//  1 指定端口，使用 ServerSocket创建服务器
        ServerSocket Server = new ServerSocket(8888);
//  2、阻塞式等待连接 一次accept就是一次连接；
        Socket client = Server.accept();
        System.out.println("建立了一个连接");
        boolean isRuning = true;
//  3、操作 输入输出流操作
        //接收client端传来的数据
        while(isRuning) {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String data = dis.readUTF();
            //传回client数据
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(data);//返回给客户端信息
            dos.flush();
//  4、释放资源
            dis.close();
            client.close();
            Server.close();
        }
    }
}