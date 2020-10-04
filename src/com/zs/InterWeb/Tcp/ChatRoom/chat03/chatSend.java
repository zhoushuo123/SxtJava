package com.zs.InterWeb.Tcp.ChatRoom.chat03;

import com.zs.InterWeb.Tcp.ChatRoom.ZsUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 客户端的发送消息
 * @author: 周硕
 * @create: 2020-09-23 10:39
 **/
public class chatSend implements Runnable{
    private BufferedReader br;
    private DataOutputStream dos;
    private Socket client;//套接字 管道
    boolean isRuning = true;
    private  String name;

    //构造器，传入 client套接字 管道 ，对接管道
    public chatSend(Socket client,String name) {
        this.client = client;
        this.name = name;
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.send(name);
        } catch (IOException e) {
            System.out.println("++++(1,2).new++++");
            release();
        }
    }
//    //从键盘读数据
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String msg = br.readLine();
//    //将数据传到Server端
//    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//            dos.writeUTF(msg);
    @Override
    public void run() {
        String msg =getStreamReader();
        if(!msg.equals("")){
            send(msg);
        }

    }


    //将数据发送到服务端 发送
    public   void  send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("+++2+++");
            release();
        }
    }

//从键盘读入数据
    public   String getStreamReader(){
        String data="";
        try {
            data = br.readLine();
        } catch (IOException e) {
            System.out.println("+++1+++");
        }
        return data;
    }
    //释放资源
    public void release() {
        this.isRuning = false;
        ZsUtils.close(dos, client);
    }
}
