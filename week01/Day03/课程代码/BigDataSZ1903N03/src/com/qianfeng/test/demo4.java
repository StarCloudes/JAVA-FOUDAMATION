package com.qianfeng.test;

public class demo4 {
	public static void main(String[] args) {
		 int a=4,b=2,c=2;
		 c *= a-- * b-- + (c++ - --b) % a++  ;
		 System.out.println(a+"  "+b+"  "+c+"   ");		
	}
}
