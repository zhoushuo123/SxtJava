package com.zs.InterWeb.Tcp.ChatRoom.chat03;

import com.zs.InterWeb.Tcp.ChatRoom.ZsUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 客户端接收消息
 * @author: 周硕
 * @create: 2020-09-23 10:39
 **/
public class chatReceive implements Runnable{
    private DataInputStream dis;
    private Socket client;//套接字 管道
    boolean isRuning = true;

    public chatReceive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("++++5.new++++");
            release();
        }
    }

    @Override
    public void run() {
        while (isRuning){
            String msg = getSeceive();
            if(!msg.equals("")){
                System.out.println(msg);
            }
        }

    }


    public String getSeceive(){
        String data="";
        try {
           data = dis.readUTF();
        } catch (IOException e) {
            System.out.println("+++5+++");
            release();
        }
        return data;
    }
    //    //接收Server传回的数据
//    DataInputStream dis = new DataInputStream(client.getInputStream());
//    String data = dis.readUTF();
//            System.out.println(data);
////    4、释放资源
//            dos.flush();

    //释放资源
    public void release() {
        this.isRuning = false;
        ZsUtils.close(dis, client);
    }
}
