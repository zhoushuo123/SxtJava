package com.zs.Thread.state;

/**
 * @program: SxtJava
 * @description: 守护线程//作用确保一些用户线程的正常执行。
 * 守护线程：是为用户线程服务的；JVM停止不用等待守护线程执行完毕
 * 默认 用户线程，JVM等待用户线程执行完毕才会停止
 * @author: 周硕
 * @create: 2020-09-14 16:25
 **/
public class Daemon {
    public static void main(String[] args) {
        God god = new God();
        You you= new You();
        Thread god1 = new Thread(god);
        god1.setDaemon(true);//设置位守护线程
        god1.start();
        new Thread(you).start();
    }
}
class God extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon Thread..");
        }
    }
}
class You extends Thread{
    @Override
    public void run() {
       for(int i =0;i<365*100;i++){
            System.out.println("happy life...");
        }
    }
}
