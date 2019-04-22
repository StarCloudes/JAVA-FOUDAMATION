package com.Test;

import java.util.Arrays;

//将一个字符数组的值拷贝到另一个字符数组中。（用至少两种方式）
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
