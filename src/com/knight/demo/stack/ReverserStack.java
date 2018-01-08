/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.stack;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 利用栈，字符串反转
 *
 * @author hujie
 * @version Id: ReverserStack.java, v 0.1 2018/1/5 15:00 hujie Exp $$
 */
public class ReverserStack {

    public static void main(String[] args) throws IOException {

        String input,output;

        while (true){
            System.out.print("Enter a String :");
            System.out.flush();
            input = getString();

            if(StringUtils.equals(input,"")){
                break;
            }

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();

            System.out.println("Reversed: " + output);
        }

    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        return s;
    }
}


class StrackX{

    private int maxSize;

    private char[] stackChar;

    private int top;

    public StrackX(int max){
        maxSize = max;
        stackChar = new char[maxSize];
        top = -1;
    }

    public void push(char j){
        stackChar[++top] = j;
    }

    public char pop(){
        return stackChar[top --];
    }

    public char peek(){
        return stackChar[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

}

class Reverser{

    private String input;

    private String output;

    public Reverser(String in){
        input = in;
    }

    public String doRev(){
        int stackSize = input.length();
        StrackX strackX = new StrackX(stackSize);

        for (int j=0; j<stackSize; j++){
            char ch = input.charAt(j);
            strackX.push(ch);
        }

        output = "";

        while (!strackX.isEmpty()){
            char ch = strackX.pop();
            output += ch;
        }

        return output;
    }
}