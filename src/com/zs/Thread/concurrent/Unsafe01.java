package com.zs.Thread.concurrent;

import com.zs.Thread.baseFunction.parallel_start;

/**
 * @program: SxtJava
 * @description: 线程不安全
 * 线程不安全，多个线程同时抢票
 * @author: 周硕
 * @create: 2020-09-14 16:56
 **/
public class Unsafe01 {
    public static void main(String[] args) {
        UnsafeWbe web = new UnsafeWbe();
        //多个代理
        new Thread(web, "01").start();
        new Thread(web, "02").start();
        new Thread(web, "03").start();

    }
}
class UnsafeWbe implements Runnable {
    //票数
    private  int ticketNums =10;
    private  boolean flat = true;

    @Override
    public /*synchronized*/ void run() {
        while (flat) {
            test();
        }
    }
    public void test() {
        boolean flat = true;
        if (ticketNums < 0) {
            flat =false;
            return;
        }
        try {
            Thread.sleep(200);//模拟网络延迟，会使得不同的代理拿到同一张票
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}