/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.text.DecimalFormat;
import java.util.concurrent.*;

/**
 *
 * Thread Pool 模式之验证码短信下发
 * @author hujie
 * @version Id: SmsVerficationCodeSender.java, v 0.1 2018/4/21 12:57 hujie Exp $$
 */
public class SmsVerficationCodeSender {


    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(1,
            Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {

            Thread t = new Thread(r,"VerfCodeSender");
            t.setDaemon(true);
            return t;
        }
    },new ThreadPoolExecutor.DiscardPolicy());


    public void sendVerificationSms(final String msisdn){

        Runnable task = new Runnable() {
            @Override
            public void run() {
                //生成强随机数验证码
                int verificationCode = ThreadSpecificSecureRandom.INSTANCE.nextInt(999999);

                DecimalFormat df = new DecimalFormat("000000");

                String txtVerCode = df.format(verificationCode);

                //发送验证码短信
                sendSms(msisdn,txtVerCode);
            }
        };

        EXECUTOR.submit(task);

    }


    private void sendSms(String msisdn,String verificationCode){

        System.out.println("Sending verification code:【" + verificationCode +"】   To   " +msisdn);
    }


    public static void main(String[] args) {

        SmsVerficationCodeSender smsVerficationCodeSender = new SmsVerficationCodeSender();
        smsVerficationCodeSender.sendVerificationSms("15221379670");
        smsVerficationCodeSender.sendVerificationSms("15221379671");
        smsVerficationCodeSender.sendVerificationSms("15221379672");

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){

        }


    }
}