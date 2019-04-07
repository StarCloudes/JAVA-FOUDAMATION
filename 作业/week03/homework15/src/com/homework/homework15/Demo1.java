package com.homework.homework15;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请问你是会员吗？1是 2否");
		int vip = scanner.nextInt();
		System.out.println("请问你的购物金额是多少？");
		int sale = scanner.nextInt();
		double check = checkOut(vip, sale);
		System.out.println("你一共消费" + check + "元");
	}

	private static double checkOut(int vip, int sale) {
		double check;
		if (vip == 1) {
			if (sale > 200) {
				check = sale * 0.75;
			} else {
				check = sale * 0.8;
			}
		} else {
			check = sale * 0.9;
		}
		return check;
	}

}
