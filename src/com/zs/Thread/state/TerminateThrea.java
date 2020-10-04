package com.zs.Thread.state;

import javax.swing.*;

/**
 * @program: SxtJava
 * @description: 状态 Terminate 使终止，使结束
 * 终止线程
 * 1 线程正常执行完毕---正常运行结束
 * 2加入标识 ---不能用stop()方法，不安全，Java中已经过时
 * @author: 周硕
 * @create: 2020-09-13 15:52
 **/
public class TerminateThrea implements Runnable {
    //加入标识 标记线程是否可以运行
    private boolean flag = true;
    private String name;

    public TerminateThrea(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        //关联标识 ture-->运行 ，false-->停止
        while (flag) {
            int i = 0;
            System.out.println(name + "-->" + i++);
        }
    }

    //3对外提供方法 改变他
    public void teminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThrea tt = new TerminateThrea("C罗");
        new Thread(tt).start();
        for (int i = 0; i < 99; i++) {
            if (i == 88) {
                tt.teminate();//线程终止
                System.out.println("tt game over");
            }
            System.out.println("mian-->" + i);
        }
    }
}
