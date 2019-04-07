package com.qianfeng.homework;

import java.util.Random;

public class hwork5 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			playCard();//调用出牌函数
		}
	}
	public static void playCard() {
		Random random = new Random();
		int num = random.nextInt(13)+1;//随机生成牌面值
		if(num < 10&&num>1) {
			System.out.println("电脑出了一张"+type()+num);
		}else {
			switch(num) {//将值与花色进行拼接
			case 1:System.out.println("电脑出了一张"+type()+"A");break;
			case 11:System.out.println("电脑出了一张"+type()+"J");break;
			case 12:System.out.println("电脑出了一张"+type()+"Q");break;
			case 13:System.out.println("电脑出了一张"+type()+"K");break;
			}
		}
	}
	public static String type() {
		Random random = new Random();
		int num = random.nextInt(4);
		switch(num) {//随机生成牌面花色
		case 0:return "方块";
		case 1:return "梅花";
		case 2:return "黑桃";
		default:return "红心";
		}
	}
}
