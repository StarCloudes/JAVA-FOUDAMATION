package com.qianfeng.practice;

//求出1〜100之间，即是3又是7的倍数出现的次数？
public class practice1 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 7 == 0) {
				count++; 
				System.out.println(i);
			} else {
				continue;
			}
		}
		System.out.println(count);
	}
}
