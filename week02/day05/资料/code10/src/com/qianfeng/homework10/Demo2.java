package com.qianfeng.homework10;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		
		int[] arr = {0,0,2,5,0,8,12};
		move(arr);
        System.out.println(Arrays.toString(arr));
	}

	public static void move(int[] arr) {
		int left = 0, right = 0;
		while (right < arr.length) {
			if (arr[right] == 0) {
				right++;
			} else {
				swap(arr, left++, right++);
			}
		}
	}

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

}
