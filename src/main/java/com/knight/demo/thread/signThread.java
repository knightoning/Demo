package com.knight.demo.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class signThread {

    private static ExecutorService threadPoolExecutor =  Executors.newFixedThreadPool(1);

    public static void main(String[] args) {


        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("threadPoolExecutor");
            }
        });


        System.out.println("game over");

    }
}
