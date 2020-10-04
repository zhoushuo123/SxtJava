package com.zs.Thread.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: SxtJava
 * @description: 多线程安全实例
 * @author: 周硕
 * @create: 2020-09-15 17:30
 **/
public class HappyCinema01 {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(5);
        available.add(4);
        available.add(6);
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        seats1.add(5);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(1);
        seats2.add(2);
        seats2.add(4);

        Cinema1 cinema = new Cinema1(available, "万达影院");
        new Thread(new Customer1(seats1, cinema), "001-->").start();
        new Thread(new Customer1(seats2, cinema), "002-->").start();
    }
}

//电影院
class Cinema1 {
    List<Integer> available;
    String name;

    public Cinema1(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean getseat(List<Integer> seat) {
        System.out.println("欢迎光临" + this.name + "可用位置：" + available);
        List<Integer> capy = new ArrayList<>();
        capy.addAll(available);
        available.removeAll(seat);
        boolean flat = false;
        if (capy.size() - available.size() == seat.size()) {
            flat = true;
        }
        return flat;
    }
}

//顾客
class Customer1 implements Runnable {
    private List<Integer> seat;
    private Cinema1 cinema;

    public Customer1(List<Integer> seat, Cinema1 cinema) {
        this.seat = seat;
        this.cinema = cinema;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flat = cinema.getseat(seat);
            if (flat) {
                System.out.println(Thread.currentThread().getName() + "--->得到:" + seat + "票");
            } else {
                System.out.println(Thread.currentThread().getName() + cinema.name + "余票不足");
            }
        }
    }
}