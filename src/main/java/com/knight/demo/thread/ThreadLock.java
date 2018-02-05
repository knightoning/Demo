package com.knight.demo.thread;

/**
 * 背景
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C，
 * 每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。如：ABCABCABC……
 */
public class ThreadLock {

    public static void main(String[] args){


        ThreadDemo ad = new ThreadDemo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    ad.loopA(i);
            }
        }, "A").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    ad.loopB(i);
            }
        }, "B").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    ad.loopC(i);
            }
        }, "C").start();
    }
}
