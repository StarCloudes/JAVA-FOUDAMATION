package com.exam.first;

import java.util.Arrays;

/*
 * 1.��һ���ַ������ֵ��������һ���ַ������С������������ַ�ʽ��
 */
public class Demo {
	public static void main(String[] args) {
		char[] a = {'��','��','��','һ','��','��','��'};
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
		return Arrays.copyOfRange(a, 0, a.length);
	}
}
