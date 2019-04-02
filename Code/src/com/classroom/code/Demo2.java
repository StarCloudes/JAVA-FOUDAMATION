package com.classroom.code;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		char[] arr1 = {'1','a','2'};
		String s1 ="2frr";
		String s2 = new String(arr1,0,2);
		System.out.println( s2);
		
		char[] arr2 = s1.toCharArray();
		for(char c: arr2) {
			System.out.print(c);
		}
		
		byte[] arr3 = "哈哈".getBytes();
		System.out.println(Arrays.toString(arr3));
		
		System.out.println(String.valueOf(true));
		
		System.out.println(s1.compareTo(s2));
		
		String s3 ="2frr deffe deee";

		System.out.println(s1.split(" ")[0]);
	}

}
