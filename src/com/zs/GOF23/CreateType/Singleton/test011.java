package com.zs.GOF23.CreateType.Singleton;



import com.zs.GOF23.CreateType.Singleton.Singleton_lazy;

import java.util.concurrent.CountDownLatch;


/**
 * @program: SxtJava
 * @description: 测试多线程下五种单例模式的效率
 * CountDownLatch :
 * 作用 在当前指定一个计数器 当前线程中每走完一个线程 计数器减一 ，知道计数器变为0，当前线程跳出等待
 * @author: 周硕
 * @create: 2020-10-01 14:59
 **/
public class test011 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        //构造一个以给定计数 CountDownLatch CountDownLatch。线程计数器

        for (int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        Object o = Singleton_lazy.getInstance();
                    }
                    countDownLatch.countDown();//线程数减一
                }
            }).start();
        }
        countDownLatch.await();//循环检测
        long end = System.currentTimeMillis();
        System.out.println("总时间"+(end-start));
    }

}
