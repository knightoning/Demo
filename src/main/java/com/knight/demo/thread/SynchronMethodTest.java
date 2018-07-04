package com.knight.demo.thread;

public class SynchronMethodTest {

    public static void main(String[] args) {

        MyService myService = new MyService();

        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);

        Thread thread1 = new Thread(threadA);
        Thread thread2 = new Thread(threadB);

        thread1.start();
        thread2.start();

    }
}

class MyService{

    private int count;

    synchronized public void methodA(){
        count ++;
        System.out.println(Thread.currentThread().getName()+ ":"+count);
    }
}


class ThreadA implements Runnable{

    private MyService myService;

    public ThreadA(MyService myService){
        this.myService = myService;
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
        myService.methodA();
    }
}

class ThreadB implements Runnable{


    private MyService myService;

    public ThreadB(MyService myService){
        this.myService = myService;
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
        myService.methodA();
    }
}