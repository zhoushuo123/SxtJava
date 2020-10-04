package com.zs.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.StringCharacterIterator;

import static java.lang.Class.forName;

/**
 * @program: SxtJava
 * @description: 通过反射API，构造对象，实现动态
 * @author: 周硕
 * @create: 2020-09-28 18:02
 **/
public class Re_createObjec {
    public static void main(String[] args) {
        String path = "com.zs.Reflection.User";
        try {
            Class clz = forName(path);
            User u = (User)clz.getDeclaredConstructor().newInstance();//调用无参构造器创建对象
            User u2 = (User)clz.getDeclaredConstructor(String.class,int.class,String.class)
                    .newInstance("老高",45,"123");//调用有参构造器创建对象
            System.out.println(u2.getName()+"----->"+u2.getAge());
            System.out.println(u.hashCode());

            //通过反射API调用普通方法
            User u3 = (User) clz.newInstance();
            Method m01 = clz.getDeclaredMethod("setName", String.class);//有参方法
            m01.invoke(u3,"周硕");//相当于      u3.setName("周硕");
            //好处 ： 方法名 ，对象名称 ，名称 都可以是不一样，是变化的，是动态的
            System.out.println(u3.getName());

            //通过反射API操作属性
            User u4 = (User) clz.newInstance();
            Field field = clz.getDeclaredField("name");
            field.setAccessible(true);//告诉属性 不用安全检查了，直接可以访问
            field.set(u4,"老李");//priver 私有的属性不能直接访问，不然报错、、、//通过反射直接写属性的值
            System.out.println(field.get(u4));//通过反射直接读

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
