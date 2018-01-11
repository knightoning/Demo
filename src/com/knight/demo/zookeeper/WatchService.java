/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * @author hujie
 * @version Id: WatchService.java, v 0.1 2018/1/10 14:44 hujie Exp $$
 */
public class WatchService implements Runnable{

    private Watcher connectionWatcher;

    private Watcher childrenWatcher;

    private ZooKeeper zk;

    private boolean alive = true;

    private final String rootPath = "/nodeRoot";

    private static final int SESSION_TIMEOUT = 10000;




    public WatchService(){

        connectionWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType() == Event.EventType.None &&
                        watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("connection watch output event:"+ watchedEvent.toString());
                }
            }
        };

        childrenWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                    try {
                        //Get current list of child znode, reset the watch
                        List<String> children = zk.getChildren(rootPath, this);
                        //Update live service objects in really environment.
                        System.out.println("Members: " + children);
                    } catch (KeeperException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        alive = false;
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        try {
            zk = new ZooKeeper("127.0.0.1:2181",SESSION_TIMEOUT,connectionWatcher);

            if(zk.exists(rootPath, false) == null) {
                    //Create the node.
                    try {
                        zk.create(rootPath,
                                "nodeChildren1".getBytes(),
                                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            // Set a watch on the parent znode
            List<String> children = zk.getChildren(rootPath, childrenWatcher);

            System.out.println("Members: " + children);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException w){
            w.printStackTrace();

        }catch (KeeperException k){
            k.printStackTrace();
        }
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

        try {

            synchronized(this){



                while (alive){

                    if(zk != null && childrenWatcher != null){

                        List<String> children = children = zk.getChildren(rootPath,childrenWatcher);

                        System.out.println("init members: " + children);

                        //wait();
                        Thread.sleep(1000);

                    }else {

                        System.out.println(" init error, try again !");

                        Thread.sleep(1000);

                    }
                }

            }

        }catch (KeeperException e){

        }catch (InterruptedException w){

        }finally {
            close();
        }


    }

    public synchronized void close(){

        try {
            zk.close();
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {

        new Thread(new WatchService()).start();
    }
}