package com.exam.sixth;
/*
 * ���һ������, ���һ��5�е�ƽ���ı���
 */
public class Demo {
	 public static void main(String[] args) {
			getShape();
		}
		static void getShape() {
			
			for (int i = 0; i < 5; i++) {
				for (int j = i; j > 0 ; --j) {
					System.out.print(" ");
				}
				for (int k = 0; k < 8; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
}
