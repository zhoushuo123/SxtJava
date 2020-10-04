package com.zs.InterWeb.udp;

/**
 * @program: SxtJava
 * @description: 模拟老师端接收和发送
 * @author: 周硕
 * @create: 2020-09-20 09:15
 **/
public class Talkteacher {
    public static void main(String[] args) {
       new Thread(new TalkReceive(6666,"学生")).start();//接收
        new Thread(new TalkSend(9999,"localhost",5555)).start();
    }
}
