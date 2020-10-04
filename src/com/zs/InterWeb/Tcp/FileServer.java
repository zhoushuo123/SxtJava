package com.zs.InterWeb.Tcp;

import java.io.*;
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
public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-------");
//  1 指定端口，使用 ServerSocket创建服务器
        ServerSocket Server = new ServerSocket(8888);
//  2、阻塞式等待连接 一次accept就是一次连接；
        Socket client = Server.accept();
        System.out.println("建立了一个连接");
//  3、操作 输入输出流操作
        //文件的copy
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("D:/java学习/SxtJava/tcp.jpg"));
        byte[] bytes = new byte[1024];
        int len = -1;
      while((len=is.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        os.flush();
//    4、释放资源
        os.close();
        is.close();
//  4、释放资源
        client.close();
        Server.close();
    }
}
