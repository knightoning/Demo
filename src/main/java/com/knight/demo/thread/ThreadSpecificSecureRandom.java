/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * 基于Thread Specific Storage 模式的强随机数生成器客户端代码
 * @author hujie
 * @version Id: ThreadSpecificSecureRandom.java, v 0.1 2018/4/21 13:12 hujie Exp $$
 */
public class ThreadSpecificSecureRandom {


    //该类的唯一实例
    public static final ThreadSpecificSecureRandom INSTANCE = new ThreadSpecificSecureRandom();


    /**
     * SECURE_RANDOM 相当于模式角色：ThreadSpecificStorage.TSObjectProxy.
     * SecureRandom 相当于模式角色：ThreadSpecificStorage.TSObject
     */
    private static final ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>(){

        @Override
        protected SecureRandom initialValue() {

            SecureRandom srnd ;
            try {
                srnd = SecureRandom.getInstance("SHA1PRNG");
            }catch (NoSuchAlgorithmException e){
                srnd = new SecureRandom();
            }

            return srnd;
        }
    };

    //私有构造器
    private ThreadSpecificSecureRandom(){}

    public int nextInt(int upperBound){
        SecureRandom secureRandom = SECURE_RANDOM.get();
        return secureRandom.nextInt(upperBound);
    }

    public void setSeed(long seed){

        SecureRandom secureRandom = SECURE_RANDOM.get();
        secureRandom.setSeed(seed);
    }
}