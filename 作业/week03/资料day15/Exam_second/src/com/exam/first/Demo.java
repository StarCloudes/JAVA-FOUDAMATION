package com.exam.first;

import java.util.Arrays;
//将一个字符数组的值拷贝到另一个字符数组中。（用至少两种方式）


public class Demo {
	public static void main(String[] args) {
		char[] a = {'k','s','a','һ','r','l','h'};
		char[] b = new char[10];

		method1(a, b);
		System.out.println(Arrays.toString(b));
		
		char[] c = method2(a);
		System.out.println(Arrays.toString(c));
		
		char[] d = method3(a);
		System.out.println(Arrays.toString(d));
	}
	
	static void method1(char[] a, char[] b) {
		System.arraycopy(a, 0, b, 0, a.length);
	}
	
	static char[] method2(char[] a) {
		return Arrays.copyOf(a, a.length);
	}
	
	static char[] method3(char[] a) {
		return Arrays.copyOfRange(a, 3, a.length);
	}
}
