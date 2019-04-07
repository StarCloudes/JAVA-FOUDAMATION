package com.qianfeng.homework;

import java.util.Random;

public class hwork3 {
	public static void main(String[] args) {
		computerPlayCard();//调用电脑出牌的函数
	}
	
	public static void computerPlayCard() {
		Random random =new Random();
		int count = 0;//定义了一个count没啥卵用，只是单纯的让循环终止，否则CPU会直接飙到100
		while(true) {
			int num = random.nextInt(13) + 1;//随机产生1~13的数
			if(num<11&&num>1) {
				System.out.println("电脑出啦一张" + num);
			}else if(num == 11) {
				System.out.println("电脑出啦一张J");
			}else if(num == 12) {
				System.out.println("电脑出啦一张Q");
			}else if(num==1) {
				System.out.println("电脑出啦一张A");
			}else {
				System.out.println("电脑出啦一张K");
			}
			count++;
			if(count==100) {//这里和上面的作用一样，就是没啥用
				break;
			}
		}
	}
}
