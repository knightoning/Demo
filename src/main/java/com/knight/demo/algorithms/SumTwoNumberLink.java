/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.algorithms;

/**
 *
 * 计算 342 + 465 = 807
 *
 * @author hujie
 * @version Id: SumTwoNumberLink.java, v 0.1 2018/6/13 09:30 hujie Exp $$
 */
public class SumTwoNumberLink {


    /**
     * 链表结构体
     */
     static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 初始化两位加数
     *
     * 倒叙存入listNode中
     * ListNode p1  2 -> 4-> 3
     * ListNode p2 5 -> 6 -> 4
     * @param p1
     * @param p2
     */
    public static void initListNode(ListNode p1,ListNode p2){
        ListNode temp = new ListNode(2);
        p1 = temp;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(6);



        temp = new ListNode(5);
        p2 = temp;
        temp.next = new ListNode(6);
        temp = temp.next;
        temp.next = new ListNode(4);

        ListNode sumListNode =  new ListNode(0);

        int overflow = 0;

        while (p1 != null || p2 != null){

            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;

            int sum_temp =  (x +y) +overflow;

            overflow = (x +y) / 10;

            sumListNode .next = new ListNode(sum_temp % 10);
            sumListNode = sumListNode.next;

            if(p1 != null ){
                p1 = p1.next;
            }

            if(p2 != null){
                p2 = p2.next;
            }
        }

        if(overflow > 0){
            sumListNode = new ListNode(overflow);
        }


        //倒叙sumListNod
        while (sumListNode!= null){
            System.out.println(sumListNode.val);
            sumListNode = sumListNode.next;
        }

    }

    public static void main(String[] args){

        ListNode p1 = null;
        ListNode p2 = null;

        initListNode(p1,p2);
    }
}