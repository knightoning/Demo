/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hujie
 * @version Id: Worker.java, v 0.1 2018/2/28 12:09 hujie Exp $$
 */
public class Worker implements Runnable {

    static AtomicInteger atomic = new AtomicInteger(0);

    //任务队列，用于取得子任务
    protected Queue<Object> workQueue;

    //子任务处理结果集
    protected Map<String,Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue){
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String,Object> resultMap){
        this.resultMap = resultMap;
    }

    public Object handle(Object input){
        return input;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {


        while (true){

            //获取子任务
            Object input = workQueue.poll();

            System.out.println("work=" + Thread.currentThread().getName() +", input="+ input);

            if(input == null ){
                break;
            }

            Object re = handle(input);

            //将处理结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()),re);
        }
    }
}