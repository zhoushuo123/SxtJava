package com.zs.Thread.concurrent;

import javax.crypto.spec.RC2ParameterSpec;

/**
 * @program: SxtJava
 * @description: 同步线程火车票
 * @author: 周硕
 * @create: 2020-09-15 18:13
 **/
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 wb = new Web12306(4,"佳运铁路");
        new Passenger(wb,"老高",2).start();
        new Passenger(wb,"老李",3).start();

    }
}
class Passenger extends Thread{
    int seats;
    String name;

    public Passenger(Runnable target,String name,int seats) {
        super(target,name);//延续父类的构造器，传入子类实际参数
        this.seats = seats;
    }
}
class Web12306 implements Runnable{
   private int available;
   private String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override

    public void run() {
        Passenger p = (Passenger) Thread.currentThread();//将当前线程强转位子类对象
        boolean flat = getseat(p.seats);
        if (flat){
            System.out.println(Thread.currentThread().getName() + "--->得到:" + p.seats+"票");
        } else {
            System.out.println(Thread.currentThread().getName() + name + "余票不足");
        }
    }
    public synchronized boolean getseat(int seat) {//锁住方法
        System.out.println("可用位置："+available);
        if (seat > available) {
            return false;
        }
        available -= seat;
        return true;
    }
}