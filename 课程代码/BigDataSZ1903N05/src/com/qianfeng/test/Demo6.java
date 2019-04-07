package com.qianfeng.test;
//* 内存中识别的函数的名字是:函数名+各个参数的类型名字
//* 函数的重载:在同一个类中,函数名相同,参数的个数,类型,位置不同的多个函数的关系.
//* 注意:1,本质上还是多个函数
//* 2.所谓的参数不同,包括个数,类型,位置.
//* 3.函数是不是重载与返回值无关
//* 
//* 重载的好处:增加的代码的可读性,可操作性.
public class Demo6 {
	public static void main(String[] args) {
		
	}
	
	static int sum(int a,int b) {//sum_int_int
		return a+b;
	}
	//是重载:参数的个数不同
	static int sum(int a,int b,int c) {//sum_int_int_int
		return a+b+c;
	}
	//是重载:参数的类型不同
	static int sum(int a,byte b) {//sum_int_byte
		return a+b;
	}
	
	//不是重载:重载跟参数的类型有关,跟参数的名字无关
//	static int sum(int c,int d) {//sum_int_int
//		return c+d;
//	}
	
	//不是重载:重载与返回值无关
//	static void sum(int a,int b) {//sum_int_int
//		return a+b;
//	}
}
