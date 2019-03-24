package com.qianfeng.practice;
import java.util.Scanner;

//计算级数 n+(n-1)+(n-2)+....+3+2+1的值，其中n的值由用户输入
public class extra01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数：");
		long num = sc.nextLong();
		long sum = 0;
		for(int i = 1; i<= num; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
}
