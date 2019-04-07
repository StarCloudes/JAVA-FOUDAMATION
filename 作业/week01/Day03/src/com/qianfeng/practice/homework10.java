package com.qianfeng.practice;

//计算1到100以内能被7或者3整除但不能同时被这两者整除的数的个数
public class homework10 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if ((i % 3 == 0 || i % 5 ==0 )&& !(i % 3 == 0 && i % 5 ==0))
				count++;
		}
		System.out.println(count);
	}
}
