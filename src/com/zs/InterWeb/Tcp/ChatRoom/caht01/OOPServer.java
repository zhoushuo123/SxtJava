package com.zs.InterWeb.Tcp.ChatRoom.caht01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SxtJava
 * @description: 服务端，监听客户端 接收
 * 模拟登陆的服务端 单向
 * 步骤：
 * 1 指定端口，使用 ServerSocket创建服务器
 * 2、阻塞式等待连接
 * 3、操作 输入输出流操作
 * 4、释放资源
 * @author: 周硕
 * @create: 2020-09-20 11:00
 **/
public class OOPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-------");
//  1 指定端口，使用 ServerSocket创建服务器
        ServerSocket Server = new ServerSocket(8888);
        boolean isRuning = true;
//  3、操作 输入输出流操作
        //System.out.println("建立了一个连接");
        while (isRuning) {
            //  2、阻塞式等待连接 一次accept就是一次连接
            Socket client = Server.accept();
            new Thread(new reServer(client)).start();
        }
        Server.close();
    }
}

class reServer implements Runnable {
    private Socket client;//套接字 管道
    private DataInputStream dis;//得到的数据流
    private DataOutputStream dos;//发送给客户端的数据流
    String datas = "";//得到的数据流转化成字符流

    //初始化
    public reServer(Socket client) {
        this.client = client;
        System.out.println("建立了一个连接");
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    //实习业务逻辑
    public void run() {
        String usname = "";
        String uspass = "";
        String[] dataArrry = rely().split("&");
        for (String info : dataArrry) {
            String[] useinfo = info.split("=");
            if (useinfo[0].equals("usname")) {//正确的登陆业务逻辑，在这的判断应该和数据库里的判断
                System.out.println("你的用户名=" + useinfo[1]);
                usname = useinfo[1];
            } else if (useinfo[0].equals("uspass")) {
                System.out.println("你的密码=" + useinfo[1]);//此处应该进行加密
                uspass = useinfo[1];
            }
        }
        if (usname.equals("zs")  && uspass .equals("zs123") ) {
            send("登陆成功");
        } else {
            send("登陆失败");
        }
        release();
    }

    //接收数据
    public String rely() {
        try {
            datas = dis.readUTF();
            return datas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    //返回客户端信息
    public void send(String msg) {
        try {
            dos.writeUTF(msg);//返回给客户端信息
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public void release() {
        try {
            if(null !=dis){
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(null !=dos){
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
        try {
            dis.close();
            dos.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }**/

    }
}
