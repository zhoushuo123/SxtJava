package com.zs.Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @program: SxtJava
 * @description: 使用反射读取注解的信息，模拟处理注解的流程
 * @author: 周硕
 * @create: 2020-09-28 15:44
 **/
public class ReflecAnnotaPass {
    public static void main(String[] args) {
        try {
           Class clz = Class.forName("com.zs.Reflection.DemoStudent");
           //获得类的所有注解
           Annotation[] annotations=clz.getAnnotations();
            for (Annotation a:annotations) {
                System.out.println(a);
            }
            //获得类的相对应的注解
            ZStable zStable = (ZStable) clz.getAnnotation(ZStable.class);
            System.out.println(zStable.value());
            try {
                //获得对应属性的注解
                Field field = clz.getDeclaredField("name");
                ZSFild zsFild = field.getAnnotation(ZSFild.class);
                System.out.println(zsFild.columName()+"---->"+zsFild.type()+"--->"+zsFild.lenght());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
