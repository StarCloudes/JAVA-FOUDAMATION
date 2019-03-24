package com.qianfeng.test;

public class Demo4 {
	public static void main(String[] args) {
		/*
		 * java将内存分成了5块儿,分别是堆区,栈区,方法区,本地方法区,寄存器
		 * 栈区:里面存放数据的特点是:先进后出,我们主要将局部变量和函数放在栈区,数据的特点是使用完立刻释放
		 * 堆区:存放的是实体(对象和数组),实体可以同时存放多个值,实体里面的变量如果不赋值,会有默认值.整型数据默认值是0,boolean---false
		 * 
		 * 了解:
		 * 堆区中的数据会在某个时刻被释放-通过垃圾回收机制.
		 * 垃圾回收机制是通过一个线程控制的,由于这个线程的等级比较低,所以不会立刻执行,数据就不会立刻释放.
		 */
		//实例:使用函数求两个数的最大值
		int m=4,n=5;
		int max = getMax(m,n);
		System.out.println(max);
		
	}
	
	static int getMax(int a,int b) {
		if (a>b) {
			return a;
		}else {
			return b;
		}
	}
}
