package com.knight.demo.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Recipes_Lock {

    private static String lock_path = "/curator_recipes_lock_path";

    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args){

        client.start();

        final InterProcessMutex lock = new InterProcessMutex(client,lock_path);

        final CountDownLatch downLatch = new CountDownLatch(1);

        for(int i=0; i< 10 ; i++){

            new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        downLatch.wait();
                        lock.acquire();
                    } catch (Exception e) {
                        System.out.println("zookeeper加锁异常："+e);
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    System.out.println("生成的订单号：" + orderNo);

                    try {
                        lock.release();
                    } catch (Exception e) {

                    }
                }
            }).start();
        }
        downLatch.countDown();
    }


}
