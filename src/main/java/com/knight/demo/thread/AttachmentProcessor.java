/**
 * Knigt.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author hujie
 * @version Id: AttachmentProcessor.java, v 0.1 2018/5/2 06:56 hujie Exp $$
 */
public class AttachmentProcessor {


    private final String ATTACHMENT_STORE_BASE_DIR = "/home/viscent/temp/attachments/";

    /**
     * 模式角色：Product-Consumer.Channel
     */
    private final Channel<File> channel = new BlockingQueueChannel<File>(
            new ArrayBlockingQueue<File>(200));

    /**
     * 模式角色：Product-Consumer.Consumer
     */
    //private final AbstractTermi
}