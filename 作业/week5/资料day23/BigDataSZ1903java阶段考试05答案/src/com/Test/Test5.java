package com.Test;
//���һ������, ���һ��9�е�����
/*
 * 
 * 			
 * 
 * 
 * 
 * 
 */
public class Test5 {
	public static void main(String[] args) {
		printShap();
	}
	public static void printShap() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 4; i >0; i--) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print(" ");
			}
			for (int j = 2*i-1; j > 0; j --) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
