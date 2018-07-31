package com.knight.demo.algorithms.stack;

import org.apache.commons.lang3.StringUtils;

public class BracketChecker {

    private String input;

    public BracketChecker(String in){
        this.input = in;
    }

    public void check(){

        int stackSize = input.length();

        StackC stackC = new StackC(stackSize);

        for (int j=0; j<stackSize;j++){

            char ch = input.charAt(j);
            switch (ch){

                case '{':
                case '[':
                case '(':
                    stackC.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stackC.isEmpty()){
                        char chx = stackC.pop();
                        if((ch == '}') && (chx != '{')||
                                (ch == ']') && (chx != '[')||
                                (ch == ')') && (chx != '(')){
                            System.out.println("Error:" + ch +" at " + j);

                        }
                    }else {
                        System.out.println("Error:" + ch +" at " + j);
                    }
                    break;
                default:
                    break;
            }

        }
        if(!stackC.isEmpty()){
            System.out.println("Error : missing right delimiter");
        }
    }
}
