package com.zs.Thread.baseFunction;

/**
 * @program: SxtJava
 * @description:
 * 方法二：1.继承接口Runnable+重写run方法
 * 2.实例化子类对象+Thread对象+satrt（）
 * 优点： 没有继承的局限性；；可以实现同意资源的共享
 * @author: 周硕
 * @create: 2020-09-07 22:30
 **/
public class StartRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        /**
        StartRunnable tr = new StartRunnable();
        Thread t = new Thread(tr);
        t.start();
         当程序种的对象只用一次时，像tr，t可以这样写
         */
        new Thread(new StartRunnable()).start();
        //td.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("一边Codeiing");
        }
    }
}
