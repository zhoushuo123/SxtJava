package com.zs.Thread.state;

import com.zs.Thread.baseFunction.parallel_start;

/**
 * @program: SxtJava
 * @description: sleep方法 模拟了网络延时 让当前线程暂停，由运行态转入阻塞状态  wait()
 * @author: 周硕
 * @create: 2020-09-13 16:19
 **/
public class BlockedThread { //票数

    public static void main(String[] args) {
        //一份资源
        parallel_start web = new parallel_start();
        //多个代理
        new Thread(web, "01").start();
        new Thread(web, "02").start();
        new Thread(web, "03").start();
    }


    class parallel_star implements Runnable {
        private int ticketNums = 99;

        public void parallel_start(int ticketNums) {
            this.ticketNums = ticketNums;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(200);//模拟网络延迟，会使得不同的代理拿到同一张票
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticketNums < 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
            }
        }
    }
}