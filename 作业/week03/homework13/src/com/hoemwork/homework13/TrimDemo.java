package com.hoemwork.homework13;

import javax.xml.stream.events.EndDocument;

public class TrimDemo {
	public static void main(String[] args) {
		String str= "  helllo  world       ";
		trim(str);
		
	}

	public static void trim(String s) {
		int i = 0;
		int j = s.length() - 1;
		
	
		while(s.charAt(i) == ' ' || i < j) {
			i++;
		}
		while(s.charAt(j) == ' '|| i < j) {
			j--;
		}
		
		if(i == j && s.charAt(i) ==' ') {
			System.out.println("空字符串");
		}
		
		System.out.println(s.substring(i,j+1));
	}
}
