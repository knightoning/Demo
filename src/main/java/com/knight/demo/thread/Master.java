/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author hujie
 * @version Id: Master.java, v 0.1 2018/2/28 11:59 hujie Exp $$
 */
public class Master {

    /**
     *  任务队列
     */
    protected Queue<Object> workQueue = new ConcurrentLinkedDeque<>();

    /**
     * Worker 进程队列
     */
    protected Map<String,Thread> threadMap = new HashMap<>();

    /**
     * 子任务处理结果集
     */
    protected Map<String,Object> resultMap = new ConcurrentHashMap<>();


    /**
     * 是否所有子任务都结束了
     * @return
     */
    public Boolean isComplete(){

        for(Map.Entry<String,Thread> entry : threadMap.entrySet()){
            if(entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }

        return true;
    }

    /**
     * Master构造器，需要一个worker进程逻辑和需要的worker进程常数
     *
     * @param worker
     * @param countWorker
     */
    public Master(Worker worker,int countWorker){

        worker.setWorkQueue(workQueue);

        worker.setResultMap(resultMap);

        for(int i=0; i<countWorker; i++){
            threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
        }
    }


    /**
     * 提交一个任务
     * @param o
     */
    public void submit(Object o){
        workQueue.add(o);
    }

    /**
     * 返回子任务结果集
     * @return
     */
    public Map<String,Object> getResultMap(){
        return resultMap;
    }

    /**
     * 开始运行所有的worker进程，进行处理
     */
    public void execute(){

        for (Map.Entry<String,Thread> entry:threadMap.entrySet()){
            entry.getValue().start();
        }

    }


}