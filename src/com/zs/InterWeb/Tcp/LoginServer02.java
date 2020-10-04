package com.zs.InterWeb.Tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 服务端，监听客户端 接收
 *模拟登陆的服务端 双向
 * 步骤：
 * 1 指定端口，使用 ServerSocket创建服务器
 * 2、阻塞式等待连接
 * 3、操作 输入输出流操作
 * 4、释放资源
 * @author: 周硕
 * @create: 2020-09-20 11:00
 **/
public class LoginServer02 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-------");
//  1 指定端口，使用 ServerSocket创建服务器
        ServerSocket Server = new ServerSocket(8888);
//  2、阻塞式等待连接 一次accept就是一次连接；
        Socket client = Server.accept();
        System.out.println("建立了一个连接");
//  3、操作 输入输出流操作
        // 分析数据
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        String[] dataArrry = datas.split("&");
        for(String info:dataArrry){
            String[] useinfo = info.split("=");
            if(useinfo[0].equals("usname")){//正确的登陆业务逻辑，在这的判断应该和数据库里的判断
                System.out.println("你的用户名="+useinfo[1]);
            }else if(useinfo[0].equals("uspass")){
                System.out.println("你的密码="+useinfo[1]);//此处应该进行加密
            }
        }
//  4、释放资源
        dis.close();
        client.close();
        Server.close();
    }
}
