package com.qianfeng.test;

public class Demo3 {
	public static void main(String[] args) {
		/*
		 * 查找:
		 * 查找的条件:1.当有多个相同的值时,只查出现的第一个,查到了立刻停止查找
		 * 2.查到了,返回当前元素的下标
		 * 3.查不到,返回-1
		 */
		//普通查找
		int[] arr1 = {3,6,1,3,8,4};
		int value1 = search(arr1, 8);
		System.out.println(value1);
		//二分查找
		int[] arr2 = {3,6,7,30,80,499};
		int value2 = binarySearch(arr2, 80);
		System.out.println(value2);
	}
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
}
