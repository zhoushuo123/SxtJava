package com.zs.Thread.state;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * @program: SxtJava
 * @description: 观察所有状态
 * @author: 周硕
 * @create: 2020-09-14 15:26
 **/
public class AllThread {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("......");
            }
        });
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        thread.start();
        state = thread.getState();// RUNNABLE
        System.out.println(state);
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();// RUNNABLE
            System.out.println(state);
        }
    }



}
