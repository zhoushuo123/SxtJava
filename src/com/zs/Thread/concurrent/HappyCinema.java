package com.zs.Thread.concurrent;

import java.util.Stack;

/**
 * @program: SxtJava
 * @description: 多线程安全实例
 * @author: 周硕
 * @create: 2020-09-15 17:30
 **/
public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(20, "万达影院");
        for (int i=0;i<7;i++) {
            new Thread(new Customer(2, cinema), "001-->"+i).start();
            new Thread(new Customer(1, cinema), "002-->"+i).start();
        }
    }
}

//电影院
class Cinema {
    int available;
    String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean getseat(int seat) {
        System.out.println("可用位置："+available);
        if (seat > available) {
            return false;
        }
        available -= seat;
        return true;
    }
}
    //顾客
    class Customer implements Runnable {
        private int seat;
        private Cinema cinema;

        public Customer(int seat, Cinema cinema) {
            this.seat = seat;
            this.cinema = cinema;
        }

        @Override
        public void run() {
            synchronized (cinema) {
                boolean flat = cinema.getseat(seat);
                if (flat){
                    System.out.println(Thread.currentThread().getName() + "--->得到:" + seat+"票");
                } else {
                    System.out.println(Thread.currentThread().getName() + cinema.name + "余票不足");
                }
            }
        }
    }