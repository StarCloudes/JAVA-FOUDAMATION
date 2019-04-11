package com.quicksort.homework17;

import java.util.Arrays;

//快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，
//通常称其为分治法。
//该方法的基本思想是：
//1．先从数列中取出一个数作为基准数。
//2．分区过程: 将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。(从小到大）
//3．再对左右区间重复第二步，直到各区间只有一个数。

//可视化数据结构与算法 https://visualgo.net/zh/sorting

public class Quicksort {

	//main函数，执行quickSort，打印排序后的数组因
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,1,4,6,8,10,5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    //快速排序的递归算法
    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)// 递归结束的条件
            return;
        int mid = partition(arr, left, right); //根据基准数划分递归范围 
        quickSort(arr, left, mid);             //递归左边  递归表达式
        quickSort(arr, mid + 1, right);        //递归右边  递归表达式
    }
    
    //根据基准数划分递归范围，以它为基准进行比大小
    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            // 从右往左找到小于key的数 
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当找到，则交换
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 从左往右找到大于key的数 
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            //当找到，则交换
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        
        //调整key的位置
        arr[left] = temp;
        return left;
    }

}