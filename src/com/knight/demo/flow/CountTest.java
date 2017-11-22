package com.knight.demo.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountTest {

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


            if(acquire()){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("业务处理中...");
            }else {
                System.out.println("业务被拒绝...");
            }


    }


    private static long limit = 10;
    private static long start = System.currentTimeMillis();
    private static long request = 0;

    private static long interv = 60;

    public static boolean acquire() {

        long now  = System.currentTimeMillis();
        if(now > start + interv){
            //判断是否进入新周期
            start = now;
            request = 0;

            return true;
        }

        request ++;
        return request < limit;
    }
}
