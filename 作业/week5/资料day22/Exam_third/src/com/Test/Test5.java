package com.Test;

import java.util.Scanner;

//设计一个方法, 判断一个数字是不是水仙花数
public class Test5 {
	public static void main(String[] args) {
		jungleNum();
	}
	public static void jungleNum() {
		System.out.println("请输入一个三位数：");
		int num = new Scanner(System.in).nextInt();
		String str = String.valueOf(num);
		if(str.length() != 3) {
			System.out.println("请输入三位数");
			return;
		}
		
		int sum = 0;
		String[] strs = str.split("");
		for(int i = 0; i<strs.length; i++) {
			sum += Math.pow(Integer.parseInt(strs[i]), 3);	
		}
		if(sum == num) {
			System.out.println(num+"是水仙花数");
		}else {
			System.out.println(num+"不是水仙花数");
		}
		
	}
}
