package com.qianfeng.practice;

public class homework2 {
//	public static void main(String[] args) {
//		String a = "" ;
//		for(int i = 1; i <= 10; i++) {
//			a += "*" ;
//			System.out.println(a);
//		}
//	}

//	public static void main(String[] args) {
//		for (int i = 1; i <= 7; i++) {
//
//			if (i % 2 == 0)
//				continue;
//			for (int j = 1; j <= (7 - i) / 2; j++) {
//				System.out.print(' ');
//			}
//
//			for (int j = 1; j < i + 1  ; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//			
//		}
//	}

	public static void main(String[] args) {
		print(5); // 输出菱形
	}

	public static void print(int size) {
		if (size % 2 == 0) {
			size++; // 计算菱形大小
		}
		for (int i = 0; i < size / 2 + 1; i++) {
			for (int j = size / 2 + 1; j > i + 1; j--) {
				System.out.print(" "); // 输出左上角位置的空白
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*"); // 输出菱形上半部边缘
			}
			
			System.out.println(); // 换行
		}
		for (int i = size / 2 + 1; i < size; i++) {
			for (int j = 0; j < i - size / 2; j++) {
				System.out.print(" "); // 输出菱形左下角空白
			}
			for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
				System.out.print("*"); // 输出菱形下半部边缘
			}
			System.out.println(); // 换行
		}
	}

}

//java不支持字符串乘法？？ 比如 ‘*’ * 5
