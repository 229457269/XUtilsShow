package com.zhaoqiang.xutils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhaoQiang on 2015/10/9.
 */

//���е�ע��   ��ʽ������@��ͷ

//@Target(ElementType.FIELD)//�Զ����Ա����   ע��

@Target(ElementType.FIELD)//ָ����ע��   Ӧ�õĶ���
//����ʱ  ����ע�⣬ָ��ע������÷�Χ   ����ֵ��Runntime:��������ʱ��ʱ���ȡ��ע��
//class,
@Retention(RetentionPolicy.RUNTIME)

public @interface CodeAuthor {
    //ע����  value����Ĭ������   ����Ҫд����
    //CodeAuthor(3): //����ע����
    int value();//����ǰע��  ����һ������ value�����ԣ���ע��   �������Ե�ʱ��ֱ�Ӿ���value=XXX
}
