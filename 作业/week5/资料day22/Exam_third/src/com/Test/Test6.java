package com.Test;
//设计一个方法, 输出一个5行的平行四边形
public class Test6 {
	public static void main(String[] args) {
		getShape();
	}
	public static void getShape() {
		int length = 5;
		for (int i = 0; i < length; i++) {
			for (int j = 5 - i; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < 10; j++) {
				if(i == 0 || i == length - 1) {
					System.out.print("*");
					continue;
				}
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}
}
