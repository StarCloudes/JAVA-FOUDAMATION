package com.qianfeng.test;
/*
 * 作用域:就是当前变量可以起作用的范围
 * 生命周期:就是变量从开始生成到被释放的过程.
 * 
 * 一般将变量分成两类:
 * 
 * 全局变量:就是直接定义在类里面的变量,作用域是整个类,有默认值,如果是整型,默认值是0,所以不赋值可以直接使用.存储在堆区
 * 局部变量:就是定义在函数或者for或者if等里面的变量.作用域是从定义当前的变量开始到他所在的函数,for或者if结束.没有默认值.
 *所以必须先赋值后使用.存储在栈区
 * 
 */
public class Demo3 {
	int age;//全局变量
	public static void main(String[] args) {
		int a=4,b;//局部变量
		
		for(int i=0;i<10;i++) {//局部变量
			//System.out.println(age);//这是暂时不能使用age,因为age不是静态的.
		}
		
	}
	
	void test(int e) {//局部变量
		int a = 4;//局部变量
		
		System.out.println(age);
	}
}
