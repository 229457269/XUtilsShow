package com.zhaoqiang.xutils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhaoQiang on 2015/10/9.
 */

//所有的注解   格式都是以@开头

//@Target(ElementType.FIELD)//自定义成员变量   注解

@Target(ElementType.FIELD)//指定的注解   应用的对象
//运行时  查找注解，指定注解的作用范围   三个值：Runntime:代表运行时的时候获取到注解
//class,
@Retention(RetentionPolicy.RUNTIME)

public @interface CodeAuthor {
    //注解中  value属于默认属性   不需要写出来
    //CodeAuthor(3): //引用注解类
    int value();//代表当前注解  包含一个叫做 value的属性，在注解   设置属性的时候，直接就是value=XXX
}
