package com.qianfeng.array;

public class reverse {

	public static void main(String[] args) {
		int a[] = { 32, 65, 12, 89, 41 };
		getReverse(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void getReverse(int[] arr) {
		int t;
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
		}
	}

}
