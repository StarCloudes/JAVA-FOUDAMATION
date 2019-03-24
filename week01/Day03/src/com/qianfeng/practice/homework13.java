package com.qianfeng.practice;
import java.util.Scanner;

//将某个8位的整数所有位的数值加在一起并输出。
public class homework13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input an 8 bit number: ");
		long num = sc.nextLong();
		long sum = 0;
		for(int i =1; i<= 8; i++) {
		   sum += num%10;
		   num /=10;
		}
		System.out.println("Sum is: "+sum);
	}
}
