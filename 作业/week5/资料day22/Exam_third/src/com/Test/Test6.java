package com.Test;
//���һ������, ���һ��5�е�ƽ���ı���
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
