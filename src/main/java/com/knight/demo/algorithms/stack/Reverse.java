package com.knight.demo.algorithms.stack;

public class Reverse {

    private String input;

    private String output;

    public Reverse(String in){
        this.input = in;
    }

    public String doRev(){

        int stackSize = input.length();

        StackC stackC = new StackC(stackSize);

        for (int j=0; j< input.length();j++){
            char ch = input.charAt(j);
            stackC.push(ch);
        }

        output = " ";

        while (!stackC.isEmpty()){
            char ch = stackC.pop();
            output =  output + ch;
        }
        return output;
    }

}
