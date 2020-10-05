package com.zs.JVM;

import javassist.*;

import java.io.IOException;

/**
 * @program: SxtJava
 * @description: 利用javassist生成一个新的类
 * @author: 周硕
 * @create: 2020-10-05 11:41
 **/
public class ByteCodeTest {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();//类池
        CtClass cc =pool.makeClass("com.zs.JVM.Emp");//创建一个新类
        //创建类的属性
        CtField f1 =CtField.make("private int empno;",cc);
        CtField f2=CtField.make("private String ename;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建类的方法
        CtMethod m1 = CtMethod.make("public int getEmpno() { return empno; }",cc);
        cc.addMethod(m1);


        //添加构造器
        CtConstructor constructor = new CtConstructor
                (new CtClass[]{CtClass.intType ,pool.get("java.lang.String")},cc);
        //CtConstructor(参数类型（基本类型，引用类型）,那个类的构造器)
        constructor.setBody("{this.empno=empno; this.ename=ename;}");//构造器的方法体
        cc.addConstructor(constructor);

        cc.writeFile("D:/Alltest");


    }
}
