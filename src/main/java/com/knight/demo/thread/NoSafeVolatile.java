package com.knight.demo.thread;

public class NoSafeVolatile {

    private static volatile int race = 0;

    /**
     * volatile修饰变量，只能保证变量的可见性，不能保证原子性，
     * 只能通过枷锁（使用synchronized或concurrent中的原子类）来保证原子性
     */
    public static synchronized void increase(){
        System.out.println(race ++);
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];

        for(int i=0; i < THREADS_COUNT; i++){

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++){
                        increase();
                    }

                }
            });

            threads[i].start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
        }

        System.out.println(race);
    }
}
