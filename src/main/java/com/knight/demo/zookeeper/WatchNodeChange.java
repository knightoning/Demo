/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author hujie
 * @version Id: WatchNodeChange.java, v 0.1 2018/1/10 14:01 hujie Exp $$
 */
public class WatchNodeChange implements Watcher{

    @Override
    public void process(WatchedEvent watchedEvent) {

        System.out.println("收到事件通知：" + watchedEvent.getType() );
        // TODO Auto-generated method stub
        if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
            System.out.println("change");
        }
        if (watchedEvent.getType() == Event.EventType.NodeDeleted){
            System.out.println("dele");
        }
        if(watchedEvent.getType()== Event.EventType.NodeCreated){
            System.out.println("create");
        }
    }
}