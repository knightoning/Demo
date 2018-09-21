package com.knight.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldMethonReflect {


    public static void main(String[] args){



        try {
            //1、获取整个类
            Class clz = Class.forName("java.lang.Integer");

            //2、获取所有属性
            Field[] fields = clz.getDeclaredFields();


            //3、定义可变长的字符串，用来存储属性
            StringBuilder sb = new StringBuilder();

            sb.append(Modifier.toString(clz.getModifiers()) + " class " + clz.getSimpleName()+"{\n");

            //遍历每一个属性
            for(Field field:fields){
                sb.append("\t");
                sb.append(Modifier.toString(field.getModifiers()) + " ");
                sb.append(field.getType().getSimpleName() + " ");
                sb.append(field.getName() +";\n");
            }

            sb.append("}");

            System.out.println(sb);

        } catch (ClassNotFoundException e) {

        }
    }
}
