package com.qianfeng.practice;

//计算1到100以内能被7整除但不是偶数的数的个数
public class homework11 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 7 == 0 && i % 2 != 0)
				count++;
		}
		System.out.println(count);
	}

}
