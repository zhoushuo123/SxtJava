package com.zs.Reflection;

/**
 * @program: SxtJava
 * @description: DRM(Object Relationship Mapping)对象关系映射
 * 作用：将就、Java中的对象与数据库中表的结构映射起来
 * 类和表结构对应 // 属性和字段对应 // 对象和记录对应
 * 1 定义一个对象 将表结构、字段和类、属性一一对应。
 * 2定义注解 给类的属性规定大小，是否为空，是否时主键等信息
 * 3使用反射机制和注解的读取工具，实现将定义的类转换成Sql语句可以创建相应的表
 * @author: 周硕
 * @create: 2020-09-28 15:21
 **/
@ZStable("tb_student")
public class DemoStudent {
    @ZSFild(columName = "id",type = "int",lenght = 10)
    private int id;
    @ZSFild(columName = "name",type = "String",lenght = 10)
    private String name;
    @ZSFild(columName = "age",type = "int",lenght = 3)
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
