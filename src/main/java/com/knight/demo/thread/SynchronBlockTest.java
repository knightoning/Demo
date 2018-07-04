package com.knight.demo.thread;

public class SynchronBlockTest {

    public static void main(String[] args) {


        Block block = new Block();

        ThreadC threadC = new ThreadC(block);
        ThreadD threadD = new ThreadD(block);

        Thread thread1 = new Thread(threadC);
        Thread thread2 = new Thread(threadD);

        thread1.start();
        thread2.start();
    }
}


class Block {

    private int count;

    public void methodA(){
        synchronized (this){
            count ++;
            System.out.println(Thread.currentThread().getName()+ ":"+count);
        }
    }
}


class ThreadC implements Runnable{

    private Block block;

    public ThreadC(Block block){
        this.block = block;
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
        block.methodA();
    }
}

class ThreadD implements Runnable{


    private Block block;

    public ThreadD(Block block){
        this.block = block;
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
        block.methodA();
    }


}