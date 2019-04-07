package com.qianfeng.practice;
import java.util.Scanner;

public class extra02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入0-9的任一正整数：");
		int num = sc.nextInt();
		System.out.println("请输入最大数字的位数：");
		int count = sc.nextInt();
		int sum = 0, temp;
		for(int i = 1; i<= count ; i++ ) {
			temp = num % 10;
			sum = sum + num;
			num = temp + num * 10;
		}
		System.out.println("这些数字和为："+ sum);
	}
}
