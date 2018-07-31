package com.knight.demo.algorithms.stack;


/**
 * 栈：先进后出
 */
public class StackTest {



    public static void main(String[] args) {

        StackL stackL = new StackL(10);

        stackL.push(20);
        stackL.push(40);
        stackL.push(60);
        stackL.push(80);

        while (!stackL.isEmpty()){

            long value = stackL.pop();

            System.out.println(value);
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
