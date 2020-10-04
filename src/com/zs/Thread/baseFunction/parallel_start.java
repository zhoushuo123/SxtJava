package com.zs.Thread.baseFunction;

/**
 * @program: SxtJava
 * @description: parallel 并发
 * 多个线性同时启动，并发； 同一资源的共享；--》并发需要保证线程安全---》  锁的引入
 * web12306 抢票  同一资源的共享，并发带来的问题
 * @author: 周硕
 * @create: 2020-09-07 22:39
 **/
public class parallel_start implements Runnable {
    //票数
    private int ticketNums = 99;

    public parallel_start(int ticketNums) {
        this.ticketNums = ticketNums;
    }

    public parallel_start() {

    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(200);//模拟网络延迟，会使得不同的代理拿到同一张票
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticketNums < 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        parallel_start web = new parallel_start();
        //多个代理
        new Thread(web, "01").start();
        new Thread(web, "02").start();
        new Thread(web, "03").start();
    }
}







