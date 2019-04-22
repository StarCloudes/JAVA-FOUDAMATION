package com.Test;

import java.util.Arrays;

//现在给出两个数组: ·数组 A :“ 1, 7, 9, 11, 13, 15, 17, 19:; ·
//数组 b :“ 2, 4, 6, 8, 10” 两个数组合并为数组 c ,按升序排列
public class Test2 {
	public static void main(String[] args) {
		int[] a = {1, 7, 9, 11, 13, 15, 17, 19};
		int[] b = {2, 4, 6, 8, 10};
		System.out.println(Arrays.toString(getNewArr(a, b)));
	}
	public static int[] getNewArr(int[] a , int[] b ) {
		int[] newArr = new int[a.length + b.length];
		int i = 0;
		for (; i < a.length; i++) {
			newArr[i] = a[i];
		}
		for (int j = 0; j < b.length; j++) {
			newArr[i] = b[j];
			i++;
		}
		sort(newArr);
		return newArr;
	}
	public static void sort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]) {
					a[j] = a[j] ^ a[j+1];
					a[j+1] = a[j] ^ a[j+1];
					a[j] = a[j] ^ a[j+1];
				}
			}
		}
	}
}
