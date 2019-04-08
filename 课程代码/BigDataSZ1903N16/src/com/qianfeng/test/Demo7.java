package com.qianfeng.test;
/*
 * 可变参数:参数的个数可以改变
 * 作用:节省代码,简化操作
 */
public class Demo7 {
	public static void main(String[] args) {
		//求两个数的和
		//1.值传递
		sum(2, 5);
		//2.址传递
		int[] arr1 = {2,4,5};
		int value1 = sum(arr1);
		System.out.println(value1);
		//3.通过可变参数
		int[] arr2 = {2,4,5};
		int value2 = sum1(arr2);
		System.out.println(value2);
		
		//可变参数的特点
		//1.给可变参数传值的实参可以直接写,个数不限制,内部会自动的将他们放入可变数组中.
		//sum1(4,5,6);
		//2.当包括可变参数在内有多个参数时,可变参数必须放在最后面,并且一个方法中最多只能有一个可变参数
		//sum1(4,5,6);  这样写不行,因为下面有两个sum1方法都有可变参数,程序调用发生错误.
		//3.当可变参数的方法与固定参数的方法是重载关系时,调用的顺序,固定参数的优先于可变参数的.
		sum2(3,4);
	}
	//值传递
	public static int sum(int a,int b) {
		return a+b;
	}
	//址传递
	public static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
	//通过可变参数
	//构成:数据类型+...    实际上就是数据类型[]  即:int[]
	public static int sum1(int... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
	//2.当包括可变参数在内有多个参数时,可变参数必须放在最后面,并且一个方法中最多只能有一个可变参数
	public static int sum1(int b,int... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
	//3.当可变参数的方法与固定参数的方法是重载关系时,调用的顺序,固定参数的优先于可变参数的.
	public static int sum2(int a,int b) {
		System.out.println("优先");
		return 3;
	}
	public static int sum2(int... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
}
