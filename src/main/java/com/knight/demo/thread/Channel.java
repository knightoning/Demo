/**
 * Knight.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

/**
 * @author hujie
 * @version Id: Channel.java, v 0.1 2018/5/2 21:42 hujie Exp $$
 */
public interface Channel<P> {

    /**
     * 从通道中取出一个"产品"
     *
     * @return "产品"
     * @throws InterruptedException
     */
    P take() throws InterruptedException;

    /**
     * 往通道中存储一个"产品"
     * @param product
     * @throws InterruptedException
     */
    void put(P product) throws InterruptedException;
}