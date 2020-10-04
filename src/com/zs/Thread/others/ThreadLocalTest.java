package com.zs.Thread.others;

import javax.swing.*;

/**
 * @program: SxtJava
 * @description: ThreadLocal：每个线程自身的数据，更改不会影响其他线程
 * get()/set()/initialValue()初始化时设置的值
 * @author: 周硕
 * @create: 2020-09-17 15:52
 **/
public class ThreadLocalTest {
    //改变初始值 第一种方式：
    private static  ThreadLocal<Integer> threadLocal =  ThreadLocal.withInitial(()->1);
/**
 * 第二种方式
    private static  ThreadLocal<Integer> threadLocal1 =  new ThreadLocal<Integer>(){
        protected Integer initialValue() {
            return 1;
        }
    };
**/
    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            new Thread(new MyRun()).start();
        }
    }


    public static class MyRun implements Runnable{
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了"+left);
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"还剩下"+threadLocal.get());

        }
    }
}
