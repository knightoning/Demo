/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.string;

/**
 * @author hujie
 * @version Id: FormatDemo.java, v 0.1 2018/2/5 09:25 hujie Exp $$
 */
public class FormatDemo {

    public static void main(String[] args) {

        String node = "leader/election/latch";

        String jobName = "master";

        //System.out.println(String.format("/%s/%s",jobName,node));


        String str = "<head><root xnmls='ssss'><MsgHeader>sssss</MsgHeader><MsgBody>bbbbb</MsgBody></root>{s:";

        int  startIndex = str.indexOf("<root");
        int  endIndex = str.indexOf("</root>");

        String dataString = str.substring(startIndex,endIndex+7);

        System.out.println("startIndex:"+startIndex+"endIndex:"+endIndex+"dataString:"+dataString);
    }
}