package com.knight.demo.algorithms.array;

/**
 * 寻找数组中的最小值与最大值,第二大值和其对应下标
 */
public class GetMaxAndMin {

    public static void main(String[] args){

        int[] a = {-10,-2,0,7,8,5,4,-9};
        getMaxAndMin(a);
    }

    /**
     * 寻找数组中的最小值与最大值
     */
    public static void getMaxAndMin(int[] a){

        //min 用来保存最小值，max用来保存最大值
        int min=0,max=0,sec=0;

        //k 用来保存最小值下标，j用来保存最大值下标
        int k=0,j=0,s=0;

        for(int i=0;i< a.length;i++){

            if(a[i] > max){
                sec = max;
                s = j;
                max = a[i];
                j = i;
            }

            if(a[i] < min){
                min = a[i];
                k=i;
            }

        }

        System.out.println("最大值为："+max+" 最大值下标为："+j+"; 第二大值为:"+sec + " 第二大值下标:"+s+"; 最小值为:"+min + " 最小值下标:"+k);

    }
}
