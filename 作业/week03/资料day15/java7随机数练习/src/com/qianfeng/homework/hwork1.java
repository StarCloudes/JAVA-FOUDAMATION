package com.qianfeng.homework;

import java.util.Scanner;

public class hwork1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("是否是会员（1代表是0代表不是）?");
		int state = sc.nextInt();
		System.out.println("请输入购物金额");
		int money = sc.nextInt();
		
		double discountMoney = discount(state,money);//调用打折的函数，返回打折后的金额
		if(discountMoney!=-1) {
			System.out.println("打折后为：" + discountMoney);
		}else {
			//System.out.println("输入不合法！");
		}
	}
	
	public static double discount(int state,int money) {
		if(state == 0) {//如果不是会员直接打9折
			System.out.println(money*0.9);
			return money*0.9;
		}else if(state == 1) {//如果是会员大于等于200打7.5折，否则打8折
			if(money >= 200) {
				//System.out.println(money*0.75);
				return money*0.75;
			}else if(money > 0 && money <200) {
				//System.out.println(money*0.8);
				return money*0.8;
			}else {
				System.out.println("输入金额不合法！");
				return -1;
			}
		}else {
			System.out.println("会员输入不合法！");
			return -1;
		}
	}
}
