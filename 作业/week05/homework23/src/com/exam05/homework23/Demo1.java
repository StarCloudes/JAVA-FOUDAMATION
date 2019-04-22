package com.exam05.homework23;

import java.util.Arrays;

//将一个字符数组的值拷贝到另一个字符数组中。
public class Demo1 {
	public static void main(String[] args) {
		char[] arr1 = {'a', 'b', 'c'};
		char[] arr2 = new char[3];
		copy2(arr1, arr2);
	}
	
	public static void copy1(char[] arr1,char[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		System.out.println(arr2);
	}
	
	public static void copy2(char[] arr1,char[] arr2) {
		arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(arr2);
	}

}
