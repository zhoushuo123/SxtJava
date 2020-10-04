package com.zs.GOF23.CreateType.Singleton;

/**
 * @program: SxtJava
 * @description: 其他单例
 * @author: 周硕
 * @create: 2020-09-30 13:52
 **/
public class Demo011 {
    public static void main(String[] args) {
        Singleton_enumeration se=Singleton_enumeration.INSTANCE;
    }
}

class Singleton_Doublecheck{
    private volatile static  Singleton_Doublecheck Instance;

    private Singleton_Doublecheck() { }

    public static  Singleton_Doublecheck getInstance() {
        if(Instance==null){
            synchronized(Singleton_Doublecheck.class) {
                if(Instance==null) {
                    Instance = new Singleton_Doublecheck();
                }
            }
        }
        return Instance;
    }
}

class Singleton_Static{//? 有反射和反序列化的问题 。违反单例原则
    //静态内部类实现
    //线程安全 调用效率高 ，并且实现了延时加载
    private static  class SingletonClassinstance{
        private  static  final  Singleton_Static Instance = new Singleton_Static();
    }
    private static  Singleton_Static getInstance(){
        return SingletonClassinstance.Instance;
    }
    public Singleton_Static(){}//私有化构造器
}

class Resource{/*类Resource是我们要应用单例模式的资源，具体可以表现为网络连接，数据库连接，线程池等等。*/}
enum  Singleton_enumeration{  //缺点  不能延时加载
/*
定义一个枚举的元素，他代表一个Singleton实例
利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题
 */
    INSTANCE;//拿到这个单例
    private Resource instance;
    Singleton_enumeration() {
        instance = new Resource();
    }
    public Resource getInstance() {
        return instance;
    }
}
