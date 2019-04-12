package com.qianfeng.test;
/*
 * 递归:有条件的自己调用自己(方法)
 * 
 * 条件:1.要给一个出口,负责结束当前的循环
 * 		2.循环次数不能太多,否则占用内存量过大,死机
 * 
 * 求:1-10之间的和
 * 
 */
public class Demo9 {
	public static void main(String[] args) {
		//利用普通的循环
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum+=i;
		}
		System.out.println(sum);
		//利用递归
		Person.run();
	}
}

class Person{
	static int sum = 0;
	static int i = 1;
	public static void run() {
		sum+=i;
		System.out.println(sum);
		if (i++ == 10) {
			return ;//给了一个出口
		}
		run();
	}
}
