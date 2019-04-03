package com.hoemwork.homework14;

import java.util.ArrayList;

public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		ArrayList list = new ArrayList<>();
		for (int i = arr.length-1 ; i >= 0; i--) {
			list.add(arr[i]);
		}
		System.out.println(list);
	}
}
