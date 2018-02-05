package com.knight.demo.flow;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 并发计数，模拟银行取款
 */
public class AtomicTest {

    public static void main(String[] args){

        final Account account = new Account(1000);

        ExecutorService executorService = Executors.newCachedThreadPool();

        int i = 0;
        while (i++ < 13){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    account.withdraw(100);
                }
            });
        }
        executorService.shutdown();
    }

    static class Account{

        private AtomicLong balance;

        public Account(long money){
            balance = new AtomicLong(money);
            System.out.println("Total Money:" + balance);
        }

        public void deposit(long money){
            balance.addAndGet(money);

        }

        public void withdraw(long money){

            //保证即时同一时间有人也在取款也可以再次尝试取款，如果不需要并发尝试取款，可以去掉这句
            for(;;){
                long oldVale = balance.get();
                if(oldVale < money){
                    System.out.println(Thread.currentThread().getName() + " 余额不足！ 余额：" + balance);
                    break;
                }

                try {
                    Thread.sleep(new Random().nextInt(1000));
                }catch (Exception e){

                }

                if(balance.compareAndSet(oldVale,oldVale - money)){
                    System.out.println(Thread.currentThread().getName() + " 取款 " + money + " 成功！ 余额：" + balance);
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " 遇到并发，再次尝试取款！");

            }
        }
    }
}
