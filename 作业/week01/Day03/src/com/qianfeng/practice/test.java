package com.qianfeng.practice;

import java.util.*;

//短路或
public class test {

	public static void main(String[] args) {
		int x =10, y = 11;

		if (x++ >= --y && x++ >= --y || x++ >= --y) {
			//x=12,y=9
			x=y++;   //10
			y=x++;   //9
			
//			x=x++;   //12
//			y=y++;   //9
			System.out.println("x=" + x + ",y=" + y);
			
		}
		
		int a =10, b = 11;
		if (a++ >= --b & a++ >= --b | a++ >= --b) {
			//a=13,b=8
			a=b++;   //9
			b=a++;   //8
			System.out.println("a=" + a + ",b=" + b);
			
		}
//		
//		int[] arr1 = new int[] {1,2};
//		Swap(arr1);
//		System.out.println(arr1[0]);
//		System.out.println(arr1[1]);	

	
	}

	static void Swap(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}

}
