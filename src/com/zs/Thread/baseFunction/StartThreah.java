package com.zs.Thread.baseFunction;

/**
 * @program: SxtJava
 * @description:
 * 实现一: 1.继承Thread类+重写run方法
 * 2.实现子类对象，调用start方法
 * 注意：不常用，应为Java的单继承的局限性 常用第二种方法
 * @author: 周硕
 * @create: 2020-09-07 22:16
 **/
public class StartThreah extends Thread{
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println("一边听歌");
        }
    }
    public static void main(String[] args) {
        StartThreah td= new StartThreah();
        td.start();//start方法，就是告诉cpu，就是把当前的线程放入就绪队列中，等待启动
        //td.run();
        for(int i=0;i<20;i++){
            System.out.println("一边Codeiing");
        }

    }
}


