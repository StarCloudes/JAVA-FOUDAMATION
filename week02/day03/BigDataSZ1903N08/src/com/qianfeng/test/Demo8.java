package com.qianfeng.test;

public class Demo8 {
	public static void main(String[] args) {
		/*
		 * final:是一个关键字,是最终的,不可改变的
		 * 
		 * 可以修饰的内容:
		 * 1.类:inal修饰的类不能有子类
		 * 2.成员变量:变量是一个终值,不能再被改变.所以在定义时必须先手动给一个值.
		 * 3.局部变量:被final修饰的局部变量是一个终值,不能再被改变
		 * 4.方法:final修饰的方法不允许重写
		 */
	}
}

//final修饰的类不能有子类
 class Fu{
	final String name = "bing";//变量是一个终值,不能再被改变.所以在定义时必须先手动给一个值.
	//final修饰的方法不允许重写
	public final void show() {
		//name = "haha";//值是不能被改变的
	    final int number;
		number = 33;//被final修饰的局部变量是一个终值,不能再被改变
//		number = 44;
		System.out.println("show");
	}
}

class Zi extends Fu{
	public void run() {
		System.out.println("run");
	}
	
//	public void show() {
//		
//	}
}
