package com.zs.InterWeb.Tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: SxtJava
 * @description: Tcp客户端 发送
 * 步骤：
 * 1 指定端口，使用Socket创建客户端+服务的地址和端口
 * 2、操作 输入输出流操作
 * 3、释放资源
 * @author: 周硕
 * @create: 2020-09-20 10:59
 **/
public class TcpClient {
    public static void main(String[] args) throws UnknownHostException,IOException {
        System.out.println("-----Client-------");
//       1 指定端口，使用Socket创建客户端+服务的地址和端口
        Socket Clicent =new Socket("localhost",8888);
//        2、操作 输入输出流操作
        DataOutputStream dos = new DataOutputStream(Clicent.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
//    4、释放资源
        dos.flush();
        Clicent.close();
    }
}
