package com.zs.Reflection;

/**
 * @program: SxtJava
 * @description:
 * @author: 周硕
 * @create: 2020-09-28 15:33
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})
@Retention( RetentionPolicy.RUNTIME)
public @interface ZStable {
    String value();//只有一个参数，建议起名魏value
}
