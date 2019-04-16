package com.exam.homework22;

public class MathUtil {
	
	public static int abs(int a) {
		if(a< 0) {
			a = -a;
		}
		return a;
	}
	
	public static int power(int a) {
		return a * a;
	}
	
	public static int bigger(int a,int b) {
		return a > b ? a : b;
	}

}
