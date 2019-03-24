package com.qianfeng.test;

import java.util.Scanner;
/*
 * 对于函数有一个原则:单一功能原则,意思就是说:一个函数应该只完成一个功能,如果有多个功能,应该写多个函数.
 * 
 * 参数的分类:
 * 实参:实际的参数,变量内部有具体的值----函数调用处的是实参
 * 形参:形式上的参数,必须通过接受实参才有值.---函数定义处的是形参
 * 我们通过参数将数据传到函数内部的过程称为传参.
 * 
 * 注意点:1.实际在函数中参与运算的是形参
 * 2.对于形参或实参有规定:他们的个数,类型,位置必须一致
 */
public class Demo10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//可以通过它接收用户的信息
		System.out.println("请输入第一个数:");
		int num1 =  scanner.nextInt();
		System.out.println("请输入第二个数:");
		int num2 =  scanner.nextInt();
		//函数调用
		int temp = sum(num1, num2);//实参
		
		System.out.println("sum:"+temp);
	}
	// 				形参:
	//我们要保证返回值类型处的数据类型与return后面 一致
	//执行过程:首先会将值传到return后面,然后再将值抛给返回值类型处,外界直接接受的是返回值类型处的数据
	static int sum(int a,int b){//a = num1  ,  b = num2
		
		int sum = a + b;
		return sum;
	}
	
//	 * 关于return:
//	 * 1.可以将数据传出函数
//	 * 2.有结束函数的功能,即return后面的代码不会执行
//	 * 3.我们要保证函数中任何条件下都能执行到return
	void test() {
		System.out.println("haha");
		return ;
		//System.out.println("hehe");
	}
	int test(int a) {
		if (a>4) {
			System.out.println("发100元");
			//return a;
		}else {
			System.out.println("发1000元");
			//return 3;
		}
		return a;
	}
}
