package com.zs.InterWeb.Tcp.ChatRoom.caht01;

import java.io.*;
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
public class chat01 {
    public static void main(String[] args) throws UnknownHostException,IOException {
        System.out.println("-----Client-------");
//       1 指定端口，使用Socket创建客户端+服务的地址和端口
        Socket client =new Socket("localhost",9999);
//        2、操作 输入输出流操作
        boolean isRuning = true;
        while(isRuning) {
            //从键盘读数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msg = br.readLine();
            //将数据传到Server端
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(msg);
            //接收Server传回的数据
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String data = dis.readUTF();
            System.out.println(data);
//    4、释放资源
            dos.flush();
            client.close();
        }
    }
}
