package com.zs.GOF23.CreateType.Prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @program: SxtJava
 * @description: 使用序列化和反序列化实现深拷贝
 * @author: 周硕
 * @create: 2020-10-03 18:05
 **/
public class SerializationTest {
    public static void main(String[] args) throws Exception {
        Date data = new Date(123412341234L);
        SerializationCopy s1 = new SerializationCopy("母体", data);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());//1


        //DeepSheep s2 = (DeepSheep) s1.clone();

        ByteOutputStream bos = new ByteOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        SerializationCopy s2 = (SerializationCopy) ois.readObject();

        s2.setName("子体");
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
        data.setTime(23423412341L);//改变母体的引用对象的属性
        System.out.println("改变母体的引用对象，母体引用对象的值：" + s1.getBirthday());//2引用对象的属性改变

        System.out.println("改变母体的引用对象，子体引用对象的值：" + s2.getBirthday());//3 拷贝的子体引用对象的属性也发生改变


    }
}
