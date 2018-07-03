package com.knight.demo.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

    private final static ArrayBlockingQueue<Apple> queue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {

       new Thread(new Producer(queue)).start();
       new Thread(new Producer(queue)).start();

       new Thread(new Consumer(queue)).start();
       new Thread(new Consumer(queue)).start();


    }
}

class Apple{
    public Apple(){

    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable{

    private final ArrayBlockingQueue<Apple> mAbq;

    Producer(ArrayBlockingQueue<Apple> mAbq) {
        this.mAbq = mAbq;
    }

    @Override
    public void run() {

        while (true){
            produce();
        }
    }

    private void produce(){

        try {

            Apple apple = new Apple();

            mAbq.put(apple);

            System.out.println("生产:"+apple);

        }catch (InterruptedException e){

        }
    }
}

class Consumer implements Runnable{

   private ArrayBlockingQueue<Apple> mAbq;

    Consumer(ArrayBlockingQueue<Apple> mAbq) {
        this.mAbq = mAbq;
    }

    @Override
    public void run() {

        while (true){

            try {
                TimeUnit.MILLISECONDS.sleep(1000);

                consume();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void consume() throws InterruptedException {

        Apple apple =  mAbq.take();

        System.out.println("消费Apple="+apple);
    }
}
