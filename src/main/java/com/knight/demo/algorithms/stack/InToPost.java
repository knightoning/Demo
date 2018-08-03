package com.knight.demo.algorithms.stack;

public class InToPost {

    private StackC stackC;

    private String input;

    private String output = " " ;

    public InToPost(String in){
        input = in;
        int stackSize = input.length();
        stackC = new StackC(stackSize);
    }

    public String doTrans(){
        for (int j=0;j<input.length();j++){

            char ch = input.charAt(j);
            stackC.displayStack("For " + ch + " ");

            switch (ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    stackC.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;

            }
        }

        while (!stackC.isEmpty()){
            stackC.displayStack("While ");
            output = output +stackC.pop();
        }
        stackC.displayStack("End    ");
        return output;
    }

    public void gotOper(char opThis,int prec1){

        while (!stackC.isEmpty()){
            char  opTop = stackC.pop();

            if(opTop == '('){
                stackC.push(opTop);
                break;
            }else {
                int prec2;

                if(opTop == '+' || opTop == '-'){
                    prec2 = 1;
                }else {
                    prec2 = 2;
                }

                if(prec2 < prec1){
                    stackC.push(opTop);
                    break;
                }else {
                    output = output + opTop;
                }
            }
        }
        stackC.push(opThis);
    }

    public void gotParen(char ch){

        while (!stackC.isEmpty()){

            char chx = stackC.pop();

            if(chx == '('){
                break;
            }else {
                output = output + chx;
            }
        }
    }
}
