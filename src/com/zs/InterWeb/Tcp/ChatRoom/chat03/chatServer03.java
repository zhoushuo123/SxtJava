package com.zs.InterWeb.Tcp.ChatRoom.chat03;

import com.zs.InterWeb.Tcp.ChatRoom.ZsUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: SxtJava
 * @description: 实现群聊
 * 思路  ：使用一个容器，把每一个新建的客户端保存下来，遍历这个数组，拿到管道中的信息，除了当前客户端不由服务端返回数据，其他都返回当前闹到的数据
 * 注意  容器的选择 多线程问题 考虑线程安全
 * @author: 周硕
 * @create: 2020-09-20 11:00
 **/
public class chatServer03 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-------");
//  1 指定端口，使用 ServerSocket创建服务器
        ServerSocket Server = new ServerSocket(9999);
//  3、操作 输入输出流操作
        while (true) {
            Socket client = Server.accept();
            System.out.println("建立了一个连接");
            new Thread(new Channel(client)).start();
        }
        //  ZsUtils.close(dis,dos,client);
    }
}


class Channel implements Runnable {
    private Socket client;//套接字 管道
    private DataInputStream dis;//得到的数据流
    private DataOutputStream dos;//发送给客户端的数据流
    boolean isRuning = true;//判断客户端正常运行，不然就关闭窗口，释放资源
    private boolean ispersonal = false;//实现群聊和私聊 利用boolear ispersonal值进行判断
    private String Cname;
    public static CopyOnWriteArrayList<Channel> users = new CopyOnWriteArrayList<>();
    ;
//问题1：定义的users容器不能添加新的线程对象

    //初始化
    public Channel(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
            //拿到名字
            this.Cname = reserver();
        } catch (IOException e) {
            System.out.println("====(3,4).new====");
            release();
        }
        users.add(this);
        this.send("欢迎来到聊天室");
    }

    //实现业务逻辑
    public void run() {
        while (isRuning) {
            String data = reserver();
            if(data.startsWith("@")){
                this.ispersonal = true;
            }
            if (!data.equals("")) {
                sendOthers(data,ispersonal);
            }
        }
    }

    //接收数据
    public String reserver() {
        String datas = "";
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            System.out.println("3-----接收");
            release();
        }
        return datas;
    }

    //返回客户端信息
    public void send(String msg) {
        try {
            dos.writeUTF(msg);//返回给客户端信息
            dos.flush();
        } catch (IOException e) {
            System.out.println("4-----发送");
            release();
        }
    }
//实现群聊和私聊
    //私发格式位@XXX:****
    public void sendOthers(String msg,boolean ispersonal) {
        if(ispersonal){
            //私发
           int index = msg.indexOf(":");
           String PerName = msg.substring(1,index);
           msg  = msg.substring(index+1,msg.length());
            for (Channel user : users) {
                if (user.Cname.equals(PerName))
                    user.send(this.Cname+"对你悄悄说"+msg);
            }
        }else {
            //群发
            for (Channel user : users) {
                if (user != this)
                    user.send(this.Cname + "对所有人说：" + msg);
            }
        }
    }
    //释放资源
    public void release() {
        this.isRuning = false;
        this.ispersonal=false;
        users.remove(this);
        this.sendOthers(this.Cname+"退出了聊天室",ispersonal);
        ZsUtils.close(dis, dos, client);
    }
}
