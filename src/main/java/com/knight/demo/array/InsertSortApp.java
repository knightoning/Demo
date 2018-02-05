/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.array;

/**
 *
 * 插入排序
 *
 * 默认标记的字段左侧有序
 * 时间复杂O(n*n)
 *
 * @author hujie
 * @version Id: BubbleSortApp.java, v 0.1 2018/1/4 15:47 hujie Exp $$
 */
public class InsertSortApp {

    public static void main(String[] args){

        int maxSize = 100;

        ArrayIns arrayIns = new ArrayIns(maxSize);

        arrayIns.insert(77);
        arrayIns.insert(99);
        arrayIns.insert(44);
        arrayIns.insert(55);
        arrayIns.insert(22);
        arrayIns.insert(88);
        arrayIns.insert(11);
        arrayIns.insert(0);
        arrayIns.insert(66);
        arrayIns.insert(33);

        arrayIns.display();

        arrayIns.insertSort();

        arrayIns.display();

    }
}

class ArrayIns{

    private long[] a;

    private int nElems;

    public ArrayIns(int max){
        this.a = new long[max];
        this.nElems = 0;
    }

    public void insert(long value){

        a[nElems] = value;

        nElems ++;
    }

    public void display(){
        for (int j=0; j<nElems; j++){
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public void insertSort(){

        int out,in;

        for(out = 1;out<nElems; out++){
            long temp = a[out];
            in = out;
            while (in >0 && a[in-1] >= temp){
                a[in] = a[in-1];
                --in;
            }

            a[in] = temp;
        }
    }

}