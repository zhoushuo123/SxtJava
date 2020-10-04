package com.zs.Thread.concurrent;


/**
 * @program: SxtJava
 * @description: 死锁  Lipstick口红     Makeup
 * @author: 周硕
 * @create: 2020-09-15 21:52
 **/
public class DeadLock {
    public static void main(String[] args) {
        new girl("大吖", 0).start();
        new girl("二吖", 1).start();
    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

class girl extends Thread {
    String name;
    int chioce;//选择0，1 0=涂口红 ，1=照镜子
    Lipstick lipstick = new Lipstick();
    Mirror mirror = new Mirror();

    public girl(String name, int chioce) {
        this.name = name;
        this.chioce = chioce;
    }

    @Override
    public void run() {
        Makeup();
    }
//Todo: 疑惑 一个线程1在拿到一的对象A的锁后，再那另一个对象B的锁，此时线程2拿到对象B的锁，想拿对象A的锁，不会造成死锁吗
    public void Makeup() {
        if (chioce == 0) {
            synchronized (lipstick) {
                System.out.println(this.name + "涂口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.name + "照镜子");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.name + "照镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(this.name + "涂口红");
                }
            }
        }
    }
}