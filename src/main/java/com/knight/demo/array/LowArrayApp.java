/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.array;

/**
 * @author hujie
 * @version Id: LowArrayApp.java, v 0.1 2018/1/4 14:40 hujie Exp $$
 */
public class LowArrayApp {

    public static void main(String[] args){
        LowArray array = new LowArray(100);
        int nElems = 0;
        int j;

        array.setElem(0,70);
        array.setElem(1,71);
        array.setElem(2,72);
        array.setElem(3,73);
        array.setElem(4,74);
        array.setElem(5,75);
        array.setElem(6,76);
        array.setElem(7,77);
        array.setElem(8,78);
        array.setElem(9,79);
        array.setElem(10,80);
        nElems = 11;

        for (j=0;j<nElems;j++){
            System.out.println(array.getElem(j) + " ");
        }


        System.out.println(" ");
    }
}

class LowArray{


    private long[] a;

    public LowArray(int size){
        this.a = new long[size];
    }

    public void setElem(int index,long value){
        a[index] = value;
    }

    public long getElem(int index){
        return a[index];
    }
}