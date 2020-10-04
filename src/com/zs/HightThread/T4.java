package com.zs.HightThread;

import java.util.concurrent.TimeUnit;

/**
 * @program: SxtJava
 * @description:
 * 一个同步方法可以调用另一个同步方法，一个线程可以拥有每一个对象的锁，
 * 再次申请时仍会得到对象的锁
 * 也就是说syschronized获得的锁是可以重入的
 * 这里是继承中有可能发生的情况，子类调用父类的同步方法
 * @author: 周硕
 * @create: 2020-09-13 19:10
 **/
public class T4 {
    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    public static void main(String[] args) {
        new tt().m1();
    }
}
class tt extends T4{
    @Override
    synchronized void m1() {
        System.out.println("child m1 satrt");
        super.m1();//掉到父类的m1这个方法，synchronized锁的是同一个对象
        System.out.println("child m1 end");
    }
}

