/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.stack;

/**
 * 栈
 *
 * 先进后出
 *
 * @author hujie
 * @version Id: StackApp.java, v 0.1 2018/1/5 14:20 hujie Exp $$
 */
public class StackApp {

    public static void main(String[] args){

        StackX stackX = new StackX(10);
        stackX.push(20);
        stackX.push(40);
        stackX.push(60);
        stackX.push(80);

        while (!stackX.isEmpty()){
            long value = stackX.pop();
            System.out.println(value + " ");
        }
    }
}

class StackX{

    private int maxSize;

    private long[] stackArray;

    private int top;

    public StackX(int s){
        this.maxSize = s;
        this.stackArray = new long[maxSize];
        this.top = -1;
    }

    public void push(long j){
        stackArray[++top] = j;
    }

    public long pop(){
        return stackArray[top --];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize -1);
    }


}