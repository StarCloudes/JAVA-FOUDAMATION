package com.qianfeng.practice;
import java.util.Scanner;

//将整数翻转
public class practice4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a number");
		long num = sc.nextLong();
		long sum = 0;
		while(num!=0) {
			sum = sum * 10 + num % 10;
			num /= 10;					
		}
		System.out.println("Reverse Num is: " + sum);
	}

}
