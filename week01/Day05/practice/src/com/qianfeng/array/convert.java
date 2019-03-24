package com.qianfeng.array;

public class convert {
	public static void main(String[] args) {
		int a[] = { 32, 65, 12, 89, 41 };
		String s1 = convertToString(a);
		System.out.print(s1);
	}

	public static String convertToString(int[] arr) {
		String s = "[";
		for (int i = 0; i < arr.length; i++) {
			if(i !=  arr.length -1)
			   s = s+ arr[i] + ",";	 
			else
			   s = s+ arr[i];	 
		}
		s = s+"]";
		return s;
	}

}
