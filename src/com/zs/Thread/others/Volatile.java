package com.zs.Thread.others;

/**
 * @program: SxtJava
 * @description: 保证线程之间变量的可见性 避免指令重排
 * @author: 周硕
 * @create: 2020-09-17 12:02
 **/
public class Volatile {
    private /* volatile */ static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();
        Thread.sleep(1000);
        num = 1;
    }
}
