package com.qianfeng.test;

public class Demo2 {
	public static void main(String[] args) {
		/*
		 * 排序:冒泡,选择,希尔,快速排序,归并排序,插入排序
		 * 
		 * 根据时间复杂度和空间复杂度选择排序方法
		 * 
		 *  * 各算法的时间复杂度
			平均时间复杂度
			插入排序 O(n2)
			冒泡排序 O(n2)
			选择排序 O(n2)
			快速排序 O(n log n)
			堆排序 O(n log n)
			归并排序 O(n log n)
			基数排序 O(n)
			希尔排序 O(n1.25)
		 */
		//冒泡排序
		int[] arr1 = {3,7,9,1};
		bubbleSort(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		//选择排序
		int[] arr2 = {3,7,9,1};
		selectSort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr2:"+arr2[i]);
		}
	}
	//冒泡排序
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {//确定的是整体的次数,比元素的个数少一
			for (int j = 0; j < arr.length-i-1; j++) {//确定一个元素需要比较的次数
				if (arr[j] > arr[j+1]) {//交换
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
				}
			}
		}
	}
	
	//选择排序
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {//确定的是整体的次数,比元素的个数少一
			for (int j = i; j < arr.length-1; j++) {//确定一个元素需要比较的次数
				if (arr[i] > arr[j+1]) {//交换
					arr[i] = arr[i] ^ arr[j+1];
					arr[j+1] = arr[i] ^ arr[j+1];
					arr[i] = arr[i] ^ arr[j+1];
				}
			}
		}
	}
}
