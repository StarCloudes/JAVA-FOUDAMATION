package com.Test;

import java.util.Arrays;

//��һ���ַ������ֵ��������һ���ַ������С������������ַ�ʽ��
public class Test3 {
	public static void main(String[] args) {
		char[] a = {'a','b'};
		char[] b = copyArr1(a);
		System.out.println(b.hashCode()+"   "+Arrays.toString(b));
		char[] c = copyArr2(a);
		System.out.println(b.hashCode()+"   "+Arrays.toString(b));
	}
	public static char[] copyArr1(char[] a) {
		return Arrays.copyOf(a, a.length);
	}
	public static char[] copyArr2(char[] a) {
		return new String(a).toCharArray();
	}
}
