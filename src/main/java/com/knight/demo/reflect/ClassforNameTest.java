/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.reflect;

/**
 * 反射
 * 1、class.forname("类路径")
 * 2、类名.class
 * 3、实例.getClass()
 *
 * @author hujie
 * @version Id: ClassforNameTest.java, v 0.1 2018/6/23 10:32 hujie Exp $$
 */
public class ClassforNameTest {


    public static void main(String[] args) {

        //使用反射机制加载类
        try {

            //class.forName("类的路径");
            Class c = Class.forName("com.knight.demo.reflect.Sub");

            //实例
            Base b = (Base)c.newInstance();

            b.f();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}