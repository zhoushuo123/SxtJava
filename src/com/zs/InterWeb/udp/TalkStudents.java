package com.zs.InterWeb.udp;

/**
 * @program: SxtJava
 * @description: 模拟学生端 调用Send和Receive类，测试双向聊天
 * //视屏会议，qq聊天 等
 * @author: 周硕
 * @create: 2020-09-20 09:08
 **/
public class TalkStudents {
    public static void main(String[] args) {
        new Thread(new TalkReceive(5555,"老师")).start();//接收
        new Thread(new TalkSend(8888,"localhost",6666)).start();//发送
    }

}
