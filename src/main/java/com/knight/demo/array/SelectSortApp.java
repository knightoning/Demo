/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package com.knight.demo.array;

/**
 *
 * 选择排序
 * 时间复杂O(n*n)
 *
 * @author hujie
 * @version Id: BubbleSortApp.java, v 0.1 2018/1/4 15:47 hujie Exp $$
 */
public class SelectSortApp {

    public static void main(String[] args){

        int maxSize = 100;

        ArraySel arraySel = new ArraySel(maxSize);

        arraySel.insert(77);
        arraySel.insert(99);
        arraySel.insert(44);
        arraySel.insert(55);
        arraySel.insert(22);
        arraySel.insert(88);
        arraySel.insert(11);
        arraySel.insert(0);
        arraySel.insert(66);
        arraySel.insert(33);

        arraySel.display();

        arraySel.selectSort();

        arraySel.display();

    }
}

class ArraySel{

    private long[] a;

    private int nElems;

    public ArraySel(int max){
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

    public void selectSort(){

        int out,in,min;

        for(out = 0;out<nElems -1; out++){
            min = out;
            for(in= out +1 ;in<nElems; in++){
                if(a[in] < a[min]){
                    min = in;
                }
            }

         //   System.out.println("min=" + min);
            swap(out,min);

          //  display();

        }
    }

    private void swap(int one, int two){

        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}