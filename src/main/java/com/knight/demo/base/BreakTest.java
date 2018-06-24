/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.base;

/**
 * @author hujie
 * @version Id: BreakTest.java, v 0.1 2018/6/24 09:36 hujie Exp $$
 */
public class BreakTest {


    public static void main(String[] args) {

        out:

        for (int i=0;i<5;i++){

            for(int j=0;j<5;j++){

                if(j >=2){
                   break out;
                }

                System.out.println(j);
            }

        }
        System.out.println("break");
    }
}