package com.hoemwork.homework13;

public class TrimDemo {
	public static void main(String[] args) {
		String str="    helllo  world     ";
		trim(str);
		
	}

	public static void trim(String s) {
		int i = 0;
		int j = s.length() - 1;
		
		while(s.charAt(i) == ' ') {
			i++;
		}
		while(s.charAt(j) == ' ') {
			j--;
		}
		
		System.out.println(s.substring(i,j+1));
	}
}
