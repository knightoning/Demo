package com.knight.demo.algorithms.array;

/**
 *
 * 求最大子数组之和
 * 一个有n个元素的数组，这n个元素可以是正数也可以是负数，数组中连续的一个或者多个元素可以组成一个连续
 * 的子数组，一个数组可能有多个这种连续的子数组，求子数组和的最大值。例如对于数组{1,-2,4,8,-4,7,-1,-5}
 * 而言，其最大和的子数组为{4,8,-4,7},最大值15。
 */
public class GetMaxSubArray {


    public static void main(String[] args){

        int[] array = {1,-2,4,8,-4,7,-1,-5};
        System.out.println(maxSubArray(array));

    }

    public static int max(int m, int n){

        return m > n ? m : n;
    }

    /**
     * 动态规划
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 实现思路：
     * 首先可以根据数组的最后一个元素arr[n-1]与最大子数组的关系分为以下3种情况：
     * 1）最大子数组的包含arr[n-1],即以arr[n-1]结尾。
     * 2）arr[n-1]单独构成最大子数组。
     * 3）最大子数组不包含arr[n-1],那么求arr[1,...,n-1]的最大子数组可以转换为求arr[1,...,n-2]
     *    最大子数组。
     * 通过上述分析可以得出结论：假设已经计算出(arr[0],...,arr[i-1])最大的一段数组和为All[i-1],
     * 同时也计算出(arr[0],...,arr[i-1])中包含arr[i-1]的最大的一段数组和为End[i-1],则可以得出如下关系
     * ：All[i-1] =  max{arr[i-1],End[i-1],All[i-2]}。
     * @param arr
     * @return
     */
    public static int maxSubArray(int arr[]){

        int n = arr.length;
        int End[] = new int[n];
        int All[] = new int[n];
        End[n-1] = arr[n-1];
        All[n-1] = arr[n-1];
        End[0] = All[0] = arr[0];
        for(int i=1; i<n; i++){
            End[i] = max(End[i-1]+arr[i],arr[i]);
            All[i] = max(End[i],All[i-1]);
        }

        return All[n-1];
    }
}
