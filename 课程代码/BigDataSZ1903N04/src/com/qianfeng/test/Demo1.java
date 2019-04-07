package com.qianfeng.test;

public class Demo1 {
	public static void main(String[] args) {
		int a =1,b=2,c =0;
		c+= a++ +b * b++ +a;
		System.out.println(a+"  "+b+"   "+c);
	}
}
