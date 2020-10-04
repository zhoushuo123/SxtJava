package com.zs.Thread.baseFunction;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.TreeMap;

/**
 * @program: SxtJava
 * @description: 用多线程的方式模拟龟兔赛跑    编程思路：用两个线程代表乌龟和兔子。这两个线程用同一个资源paly类。看这连个线程谁达到条件，跑完路程Step（循环次数），谁就是胜利者
 * @author: 周硕
 * @create: 2020-09-08 16:15
 **/
public class tortoise_rabbit_race implements Runnable {
    private String winner;//胜利者

    @Override
    public void run() {
        for (int step = 0; step <=200; step++) {
            //模拟休息
            if(Thread.currentThread().getName().equals("rabbit")){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + step);
            //比赛是否结束
            if (gemeOver(step)) {
                break;
            }
        }
    }

    //判断谁是胜利者
    private boolean gemeOver(int step) {
        if (winner != null) {
            return true;
        } else {
            if (step == 200) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是--->" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //同一资源
        tortoise_rabbit_race player = new tortoise_rabbit_race();
        //不同代理
        new Thread(player, "tortoise").start();
        new Thread(player, "rabbit").start();
    }
}