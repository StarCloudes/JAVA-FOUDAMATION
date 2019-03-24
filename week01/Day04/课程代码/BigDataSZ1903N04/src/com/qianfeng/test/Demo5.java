package com.qianfeng.test;

public class Demo5 {
	public static void main(String[] args) {
		/*
		 * 分支语句 
		 */
		//实例:一年四季,要求当我给出一个月份的时候告诉我是那个季节的
		//分析:春:3,4,5    夏:6,7,8    秋: 9,10,11    冬:12,1,2
		int a = 15;
		if (a == 3) {
			System.out.println("春");
		}else if (a == 4) {
			System.out.println("春");
		}else if (a == 5) {
			System.out.println("春");
		}else if (a == 6) {
			System.out.println("夏");
		}else if (a == 7) {
			System.out.println("夏");
		}else if (a == 8) {
			System.out.println("夏");
		}else if (a == 9) {
			System.out.println("秋");
		}else if (a == 10) {
			System.out.println("秋");
		}else if (a == 11) {
			System.out.println("秋");
		}else if (a == 12) {
			System.out.println("冬");
		}else if (a == 1) {
			System.out.println("冬");
		}else {
			System.out.println("冬");
		}
		
		//改进
		if (a<1 && a>12) {
			System.out.println("输入范围应该在1-12之间,您超出了范围,请重新输入");
		}else {
			if (a >= 3 && a <= 5) {
				System.out.println("春");
			}else if (a == 6 || a == 7 || a == 8) {
				System.out.println("夏");
			}else if (a == 9 || a == 10 || a == 11) {
				System.out.println("秋");
			}else {
				System.out.println("冬");
			}
		}
		
		//语法的注意点:
		//1.如果if后面没有加{},默认跟着一条语句,如果要跟多条,就要加{}
		if (a<3) 
			System.out.println("haha");
			System.out.println("hehe");
	    //2.可以直接跟空语句
		if (a<4);
		
	}
}
