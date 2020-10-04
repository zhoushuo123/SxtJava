package com.zs.InterWeb.Tcp.ChatRoom.caht01;

import com.zs.InterWeb.Tcp.Use;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: SxtJava
 * @description: Tcp客户端 发送
 * 模拟登陆的客户端单向
 * 步骤：
 * 1 指定端口，使用Socket创建客户端+服务的地址和端口
 * 2、操作 输入输出流操作
 * 3、释放资源
 * @author: 周硕
 * @create: 2020-09-20 10:59
 **/
public class OOPClient {
    public static void main(String[] args)  {
       moreclient client1 = new moreclient("localhost",8888);
       client1.Output(client1.Intput());
       client1.respones();
       client1.Allcose();
    }
    static class moreclient {
        private Use use1;
        private Socket clicent;
        private BufferedReader br;
        private int Serprox;
        private String SerIp;
        private DataOutputStream dos;
        private DataInputStream dis;

        public moreclient(String SerIp,int prox) {
            this.SerIp =SerIp;
            this.Serprox = prox;
            try {
                clicent = new Socket(SerIp,Serprox);
                dos = new DataOutputStream(clicent.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //键盘向客户端输入
        public Use Intput(){
            br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("请输入用户名：");
                String usname = br.readLine();
                System.out.println("请输入密码：");
                String uspass = br.readLine();
                use1 = new Use(usname,uspass);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return use1;
        }
        //客户端向服务端输入
        public void Output(Use use){
            try {
                dos.writeUTF("usname="+use.name+"&"+"uspass="+use.pass);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //服务端返回数据
        public void respones(){
            try {
                dis = new DataInputStream(clicent.getInputStream());
                String reault  =dis.readUTF();
                System.out.println(reault);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭资源
        public void Allcose(){
            try {
                dos.close();
                clicent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
