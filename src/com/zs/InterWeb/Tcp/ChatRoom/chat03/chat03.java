package com.zs.InterWeb.Tcp.ChatRoom.chat03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 实现群聊
 * @author: 周硕
 * @create: 2020-09-23 10:37
 **/
public class chat03 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-------");
//       1 指定端口，使用Socket创建客户端+服务的地址和端口
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name = br.readLine();
        Socket client =new Socket("localhost",9999);
//        2、操作 输入输出流操作
            new Thread(new chatSend(client,name)).start();
            new Thread(new chatReceive(client)).start();
    }
}
