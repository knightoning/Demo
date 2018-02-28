/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

/**
 * @author hujie
 * @version Id: PlusWorker.java, v 0.1 2018/2/28 12:23 hujie Exp $$
 */
public class PlusWorker extends Worker{

    @Override
    public Object handle(Object input){

        Integer i = (Integer) input;

        return i*i*i;
    }
}
