package com.qianfeng.practice;
import java.util.Scanner;

//判断是否是回文数
public class practice5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字");
		long num = sc.nextLong();
		long temp = num;
		long sum = 0;
		while(num!=0) {
			sum = sum * 10 + num % 10;
			num = num / 10;					
		}
		if(sum == temp) 
			System.out.println("该数是回文数");
		else
			System.out.println("该数不是回文数");
	}	
}
