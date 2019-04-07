package com.qianfeng.practice;

public class practice7 {

//01  运算符++ -- 	
//	public static void main(String[] args) {
//		int x = 0, y = 1;
//		if (++x == y-- & x++ == 1 || --y == 0)
//			System.out.println("x=" + x + ",y=" + y);
//		else
//			System.out.println("y=" + y + ",x=" + x);
//	}

//02  运算符++ -- 
//	public static void main(String[] args)
//	{
//		int a=3,b=8;
//
//		int c=(a>b)?a++:b++;
//		System.out.println("a="+a+"\tb="+b+"\tc="+c);  
//
//		int d=(a>b)?++a:++b;
//		System.out.println("a="+a+"\tb="+b+"\td="+d);  
//
//		int e=(a<b)?a++:b++;
//		System.out.println("a="+a+"\tb="+b+"\te="+e); 
//
//		int f=(a<b)?++a:++b;
//		System.out.println("a="+a+"\tb="+b+"\tf="+f);
//	}

//03  条件语句执行判断
//	public static void main(String[] args) {
//		int m = 1, n = 3;
//		if (m > 0) {
//			if (n > 2)
//				System.out.println("A");
//			else
//				System.out.println("B");
//		}
//	}

//04  循环语句执行判断 	
//	public static void main(String[] args) {
//		int i = 0, j = 5;
//		tp: for (;;) {
//			i++;   //i=1
//			cc: for (;;) {
//				if (i > j--)  //j=-1
//					break tp;
//			}
//		}
//		System.out.println("i = " + i + ", j = " + j);
//	}

//05 布尔值与条件语句
//	public static void main(String[] args) {
//		String foo = "blue";
//		boolean[] bar = new boolean[2];
//		if (bar[0]) {
//			foo = "green";
//		}
//		System.out.println(foo);
//	}

//06 注意变量与函数的关系 return后的值需要增加变量去接收
//	public static void rightshift(int i, int j) {
//		i += j;
//		System.out.println("void里的值"+ i);
//	}
//	
//	public static int leftshift(int i, int j) {
//		i += j;
//		return i;
//	}
//
//	public static void main(String args[]) {
//		int i = 4, j = 2;
//		rightshift(i,j);
//		int temp = leftshift(i, j);
//		System.out.println("main里的值"+ i);
//		System.out.println("执行函数后值"+ temp);
//	}

//07 数组类型是引用型，可以通过外部改变其内部的值
	public static void main(String[] args) {
		int[] a = new int[1];
		modify(a);
		System.out.println(a[0]);
	}

	public static void modify(int[] a) {
		a[0]++;
		
	}

//08 打印星星
//	public static void main(String[] args) {
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j <= 5 - i; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*" + " ");
//			}
//			System.out.println();
//		}
//	}

}
