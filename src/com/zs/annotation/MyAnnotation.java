package com.zs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: SxtJava
 * @description: 自定一个注解
 * 1通常加两个元注解
 * @Target
 * 描述注解的范围（即你定义的这个注解可以用在什么地方）
 * @Retention
 * 保留策略  SOURCE 在源文件中有效  CLASS 在class文件中有效
 *       RUNTIME   在运行时有效  位Runtime可以被反射
 * @author: 周硕
 * @create: 2020-09-27 11:02
 **/
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

}
