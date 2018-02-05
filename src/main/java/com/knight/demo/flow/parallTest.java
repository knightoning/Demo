package com.knight.demo.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**a
 * 限流 并发
 */
public class parallTest {

    /**
     * 并发限流入口
     * @param args
     */
    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i=0; i< 100; i++){
            executorService.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            handle();
                        }
                    }
            );
        }

    }

    public static void handle(){

        try {
            if(acquire()){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("业务处理中...");
            }else {
                System.out.println("业务处理中受阻...");
            }
        }finally {
            release();
        }

    }

    private static  final Semaphore semaphore = new Semaphore(10);

    /**
     * 获取并发锁
     * @return
     */
    public static boolean acquire() {

        return semaphore.tryAcquire();

    }

    /**
     * 释放并发锁
     */
    public static void release(){
        semaphore.release();
    }

}
