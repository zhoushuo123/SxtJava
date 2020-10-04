package com.zs.InterWeb.Tcp.ChatRoom.chat02;

import java.io.IOException;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 封装客户端
 * @author: 周硕
 * @create: 2020-09-23 10:37
 **/
public class chat02 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-------");
//       1 指定端口，使用Socket创建客户端+服务的地址和端口
        Socket client =new Socket("localhost",9999);
//        2、操作 输入输出流操作
            new Thread(new chatSend(client)).start();
            new Thread(new chatReceive(client)).start();
    }
}
