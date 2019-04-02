package com.hoemwork.homework13;

import com.sun.accessibility.internal.resources.accessibility;

public class SortString {
	public static void main(String[] args) {
		String string = "aedcbfg";
		sort(string);
	}
	
	public static void sort(String s) {
		char[] s1 = s.toCharArray() ;
		sortString(s1);
		String s2 = new String(s1) ;
		System.out.println(s2);	
	}

	public static void sortString(char[] s) {
		for(int i = 0; i < s.length-1 ;i++) {
			for (int j = i; j < s.length-1 ; j++) {
				if(s[i] > s[j]) {
					char temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
	
	}
}
