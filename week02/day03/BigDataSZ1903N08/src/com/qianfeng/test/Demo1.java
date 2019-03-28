package com.qianfeng.test;

public class Demo1 {
	/*
	 * 练习:1.使用函数实现加减乘除的运算并返回值
	 */
	public static void main(String[] args) {
		//测试
	}
	
	public static int jisuan(int a,int b,char c) {
		int temp = 0;
		if (c == '+') {
			temp= a+b;
		}else if (c == '-') {
			temp = a-b;
		}else if (c == '*') {
			temp = a*b;
		}else if (c == '/') {
			if (b != 0) {
				temp = a/b;
			}else {
				System.out.println("除数为零了");
			}
			
		}
		
		return temp;
	}
}
