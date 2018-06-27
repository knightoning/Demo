/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.oom;

import java.util.Vector;

/**
 * 内存泄漏
 *
 * java.lang.OutOfMemoryError: Java heap space
 * 当被分配的对象可达但已无用（未对作废数据内存单元的引用置null）即会引起
 * 内存泄露是导致内存溢出的原因之一；内存泄露积累起来将导致内存溢出
 * 内存泄露可以通过完善代码来避免；内存溢出可以通过调整配置来减少发生频率，但无法彻底避免。
 * @author hujie
 * @version Id: OOMTest1.java, v 0.1 2018/6/22 09:32 hujie Exp $$
 */
public class OOMTest1 {

    public static void main(String[] args) {

        Vector v = new Vector();
                        //10485760
        for(int i=1;i<1000000000;i++){

            //此时，所有的Object对象都没有被释放，因为变量v引用这些对象。
            Object o = new Object();
            v.add(o);

            o= null;

            if(i==10485760){
                System.gc();
            }

            System.out.println(i);
        }
    }
}