package com.knight.demo.algorithms.stack;

/**
 * 栈模型：先进后出
 */
public class StackC {

    private int maxSize;

    private char[] stackArray;

    private int top;

    public StackC(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    /**
     * 压栈
     * @param j
     */
    public void push(char j){
        stackArray[++top] = j;
    }

    /**
     * 弹栈
     */
    public char pop(){

        return stackArray[top--];
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public long peek(){
        return stackArray[top];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * 判断栈是否已满
     * @return
     */
    public boolean isFull(){
        return (top == maxSize -1);
    }

    public int size(){
        return top +1;
    }

    public char peekN(int n){
        return stackArray[n];
    }

    /**
     * 打印栈信息
     * @param s
     */
    public void displayStack(String s){

        System.out.print(s);
        System.out.print("Stack (bottom --> top):");
        for (int j=0;j<size();j++){
            System.out.print(peekN(j));
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
