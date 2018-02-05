package com.knight.demo.flow;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * 滑动窗口计数限流
 *
 */
public class SlideWindowsCountTest {


    static final LoadingCache<Long,AtomicLong> counter =
            CacheBuilder.newBuilder()
                    .maximumSize(100)
                    .expireAfterWrite(1*1000, TimeUnit.MILLISECONDS)
                    .build(new CacheLoader<Long, AtomicLong>() {
                        @Override
                        public AtomicLong load(Long seconds) throws Exception {
                            return new AtomicLong(0);
                        }
                    });


        public static void main(String[] args){

        long limit = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //打印形式
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    printTotal();
                }
            }
        });

        //并发测试
        for (int i=0; i<10;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            sleep((int)(Math.random() * 1000));
                        } catch (InterruptedException e) {
                        }

                        long currentSeconds = System.currentTimeMillis()/1000;
                        if(getTotal() > limit){

                            System.out.println("限流了：" + currentSeconds);
                            continue;
                        }

                        try {
                            counter.get(currentSeconds).incrementAndGet();
                        } catch (ExecutionException e) {
                        }
                    }
                }
            });
        }
    }

    public static void printTotal(){

        ConcurrentMap<Long,AtomicLong> longConcurrentMap = counter.asMap();
        StringBuilder total = new StringBuilder();

        Set<Long> longs = longConcurrentMap.keySet();

        ArrayList<Long> ts = new ArrayList<>(longs);

        Collections.sort(ts);

        for(Long along : ts){
            total.append(longConcurrentMap.get(along)).append(",");
        }
        System.out.println(total);

    }

    public static long getTotal(){
        ConcurrentMap<Long,AtomicLong> longConcurrentMap = counter.asMap();
        int total = 0;

        for(AtomicLong atomicLong : longConcurrentMap.values()){
            total += atomicLong.get();
        }

        return total;
    }
}
