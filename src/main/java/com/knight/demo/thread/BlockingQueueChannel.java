/**
 * Knigt.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.util.concurrent.BlockingQueue;

/**
 * @author hujie
 * @version Id: BlockingQueueChannel.java, v 0.1 2018/5/2 21:58 hujie Exp $$
 */
public class BlockingQueueChannel<P> implements Channel<P>{

    private final BlockingQueue<P> queue;

    public BlockingQueueChannel(BlockingQueue<P> queue) {
        this.queue = queue;
    }

    /**
     * 从通道中取出一个"产品"
     *
     * @return "产品"
     * @throws InterruptedException
     */
    @Override
    public P take() throws InterruptedException {
        return queue.take();
    }

    /**
     * 往通道中存储一个"产品"
     *
     * @param product
     * @throws InterruptedException
     */
    @Override
    public void put(P product) throws InterruptedException {
        queue.put(product);
    }
}