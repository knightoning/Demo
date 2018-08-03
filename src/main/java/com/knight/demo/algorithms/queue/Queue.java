package com.knight.demo.algorithms.queue;

/**
 * 队列模型
 */
public class Queue {

    /**
     * 最大队列长度
     */
    private int maxsize;

    /**
     * 队列数组
     */
    private long[] queArray;

    /**
     * 队列头指针
     */
    private int front;

    /**
     * 队列尾指针
     */
    private int rear;

    /**
     * 队列大小
     */
    private int nTtems;

    public Queue(int s){

        maxsize = s;

        queArray = new long[maxsize];

        front = 0;

        rear = -1;

        nTtems = 0;

    }

    /**
     * 进队列
     *
     * @param j
     */
    public void insert(long j){

        if(rear == maxsize -1){
            rear = -1;
        }

        queArray[++rear] = j;

        nTtems++;
    }

    /**
     * 出队列
     *
     * @return
     */
    public long remove(){

        long temp = queArray[front++];

        if(front == maxsize){
            front = 0;
        }

        nTtems--;

        return temp;
    }

    public long peekFront(){

        return queArray[front];
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty(){

        return (nTtems == 0);
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){

        return (nTtems == maxsize);
    }

    /**
     * 队列大小
     *
     * @return
     */
    public int size(){

        return nTtems;
    }


}
