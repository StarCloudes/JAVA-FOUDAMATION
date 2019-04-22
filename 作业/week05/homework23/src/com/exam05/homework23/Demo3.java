package com.exam05.homework23;

//设计一个方法, 输出一个9行的菱形
public class Demo3 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= 2*i -1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
