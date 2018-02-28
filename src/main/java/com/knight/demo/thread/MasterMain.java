/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.thread;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author hujie
 * @version Id: MasterMain.java, v 0.1 2018/2/28 12:25 hujie Exp $$
 */
public class MasterMain {

    public static void main(String[] args) {

        Master m = new Master(new PlusWorker(),10);

        for(int i=1;i<=200;i++){
            m.submit(i);
        }

        m.execute();

        int re = 0;

        Map<String,Object> resultMap = m.getResultMap();

        while (resultMap.size() > 0 || !m.isComplete()){

            Set<String> keys = resultMap.keySet();
            String key = null;

            for (String k : keys){
                key = k;
                break;
            }

            Integer i = null;
            if(key != null){
                i = (Integer)resultMap.get(key);
            }

            if(i != null){
                re += i;
            }

            if(key != null){
                resultMap.remove(key);
            }

        }

        System.out.println(re);
    }
}