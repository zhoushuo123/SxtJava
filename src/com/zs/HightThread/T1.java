package com.zs.HightThread;

import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.xml.transform.TransformerException;

/**
 * @program: 马士兵高并发
 * @description: 分析一下这个小程序的输出
 * 1 读不到其他线程的count改变
 * 2 输出的与自己当前线程的count也不一定相同
 * volatile 数据的可见性
 * synchronized 既保证了原子性，也保证了可见性
 * @author: 周硕
 * @create: 2020-09-13 16:34
 **/
public class T1 implements  Runnable{
    private   /*volatile */int count = 100;
    @Override
    public /*synchronized */void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"count"+count);
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        for(int i=0;i<100;i++){
            new Thread(t1,"THREAD"+i).start();
        }
    }
}
