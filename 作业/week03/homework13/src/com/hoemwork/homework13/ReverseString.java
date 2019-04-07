package com.hoemwork.homework13;

public class ReverseString {
	public static void main(String[] args) {
		String string = "abcdefg";
		reverse(string, 1, 4);
	}
	
	public static void reverse(String s, int start,int end) {
		char[] s1 = s.toCharArray() ;
		reverseArray(s1, start, end);
		String s2 = new String(s1) ;//将字符数组转换成字符串
		System.out.println(s2);	
	}

	public static void reverseArray(char[] s, int start,int end) {
		while(start<end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

}
