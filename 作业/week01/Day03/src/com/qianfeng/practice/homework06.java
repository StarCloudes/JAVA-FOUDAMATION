package com.qianfeng.practice;

//计算2的20次方
public class homework06 {
	public static void main(String[] args) {
		int multi = 2;
		for (int i = 1; i <= 20; i++) {
			multi = 2 * multi;
		}
		System.out.println(multi);
	}

}
