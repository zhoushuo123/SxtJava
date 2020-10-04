package com.zs.WebServer.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 服务端
 * @author: 周硕
 * @create: 2020-09-27 14:52
 **/
public class Server01 {
    private ServerSocket serverSocket;
    private Socket client;

    public static void main(String[] args) {
        Server01 server = new Server01();
        server.start();
    }

    //服务器启动
    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
            this.reserver();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //接收处理
    public void reserver() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接...");
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024*10];
            int len = is.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
    //服务器停止
    public void stop() {
        try {
            if(null!=client)
                client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(null!=serverSocket)
                serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}