package com.knight.demo.jdk8NF;

import com.knight.demo.json.JsonUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players =  Arrays.asList(atp);

        for(String str : players){
            System.out.print(str + ";");
        }

        System.out.println();


        players.forEach((player)->System.out.print(player + ";"));


        System.out.println("**************Runnable************************");

        //Lambda 实现Runnable
        //1.1、使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World ! --------");
            }
        }).start();

        //1.2、使用lambda表达式
        new Thread(()->System.out.println("Hello World ! ----lambda----")).start();

        System.out.println("****************Runnable**********************");


        //2.1 使用匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World ! --------");
            }
        };

        //2.2、使用lambda表达式
        Runnable runnable1 = () ->System.out.println("Hello World ! ---lambda-----");

        runnable.run();
        runnable1.run();


        System.out.println("*******************Sort*******************");


        //3.1 使用匿名内部类根据name排序
        Arrays.sort(atp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
        System.out.println("*******************Sort after       "+ JsonUtil.toJson(atp));

        //3.2 使用lambda 表达式 sort
        Arrays.sort(atp,(String s1,String s2)->s1.compareTo(s2));
        System.out.println("*******************Lambda Sort after"+ JsonUtil.toJson(atp));

    }
}
