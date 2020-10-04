package com.zs.GOF23.CreateType.Singleton;

/**
 * @program: SxtJava
 * @description: 单例模式
 * @author: 周硕
 * @create: 2020-09-30 13:33
 **/
public class Demo010 {
    public static void main(String[] args) {

    }
}

class Singleton_hungry { //线程安全 ，调用效率高，但是不能延时加载
   private static /*final*/ Singleton_hungry Instance = new Singleton_hungry();
   //加载类 类初始化的时候直接创建对象，所以饿汉式式天然的线程安全 。所以不需要加/*synchronized */ 锁
   private Singleton_hungry() {
   }
// 方法不需要  /*synchronized */ 修饰 ，也就是说没有同步 。所以效率高
   public static /*synchronized */ Singleton_hungry getInstance() {
       return Instance;
   }
}

class Singleton_lazy { //线程synchronized 用安全 ，调用效率低，可以能延时加载
    private static /*final*/ Singleton_lazy Instance;

    private Singleton_lazy() { }

    //方法同步
    public static synchronized  Singleton_lazy getInstance() {
        if(Instance==null){
            Instance = new Singleton_lazy();
        }
        return Instance;
    }
}
