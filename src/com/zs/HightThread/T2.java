package com.zs.HightThread;

/**
 * @program: 马士兵高并发
 * @description: 同步方法和非同步方法是否可以同时调用；就是掉m1的时候能否掉m2
 *
 * @author: 周硕
 * @create: 2020-09-13 16:44
 **/
public class T2 {
    //同步方法
    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+"m1 start..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end..");

    }
    //非同步方法
    public void m2(){
        System.out.println(Thread.currentThread().getName()+"m2 start..");
        //m2.satrt...如果在m1.start...和m1.end...之间显示，证明在m1运行时，可以掉m2
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m2 end..");

    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        /*
        new Thread(()->t2.m1,"m1").start();
         */
        new Thread(t2::m1,"m1").start();
        new Thread(t2::m2,"m2").start();

        /*1.8jdk 之前
        new Thread(new Runnable(){
            @Override
            public void run() {
                t2.m1();
            }
        }).start();
         */
    }
}
