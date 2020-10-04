package com.zs.Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME)
public @interface ZSFild {
    String columName();//表中的列名
    String type();//列的类型
    int lenght();//列属性的长度

}
