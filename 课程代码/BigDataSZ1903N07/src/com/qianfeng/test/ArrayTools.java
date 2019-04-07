package com.qianfeng.test;

public class ArrayTools {
	//普通查找
		public static int search(int[] arr,int key) {
			for (int i = 0; i < arr.length; i++) {
				if (key == arr[i]) {
					return i;
				}
			}
			return -1;
		}
		//二分查找:数组必须是有序的
		public static  int binarySearch(int[] arr,int key) {
			int l = 0;
			int h = arr.length-1,m;
			
			while (l <= h) {
				m = (l+h)/2;
				if (arr[m] == key) {
					return m;
				}else if (arr[m] > key) {
					h = m-1;
				}else if (arr[m] < key) {
					l = m+1;
				}
			}
			return -1;
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
