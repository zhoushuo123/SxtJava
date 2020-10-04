package com.zs.InterWeb.Tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: SxtJava
 * @description: Tcp客户端 发送   请求响应式，单个请求
 * 模拟登陆的客户端 双向
 * 步骤：
 * 1 指定端口，使用Socket创建客户端+服务的地址和端口
 * 2、操作 输入输出流操作
 * 3、释放资源
 * @author: 周硕
 * @create: 2020-09-20 10:59
 **/
public class LoginClient02 {
    public static void main(String[] args) throws UnknownHostException,IOException {
        System.out.println("-----Client-------");
//       1 指定端口，使用Socket创建客户端+服务的地址和端口
        Socket Clicent =new Socket("localhost",8888);

//        2、操作 输入输出流操作
        //        从键盘获得输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String usname = br.readLine();
        System.out.print("请输入密码：");
        String uspass = br.readLine();
        //TODO；使用use对象，需要用到对象的序列化
        //ObjectInputStream Ouse = new ObjectInputStream(new InputStream())

        //Use use = new Use(usname,uspass);
        DataOutputStream dos = new DataOutputStream(Clicent.getOutputStream());
        dos.writeUTF("usname="+usname+"&"+"uspass="+uspass);
//    4、释放资源
        dos.flush();
        Clicent.close();
    }
}
