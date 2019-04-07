package com.homework.homework15;

import java.util.Random;

public class Demo3 {
	public static void main(String[] args) {
		computerPlayCard();
	}
	
	public static void computerPlayCard() {
		Random random =new Random();
		int count = 0;
		while(true) {
			int num = random.nextInt(13) + 1;
			if(num<11&&num>1) {
				System.out.println("电脑出了一张" + num);
			}else if(num == 11) {
				System.out.println("电脑出了一张J");
			}else if(num == 12) {
				System.out.println("电脑出了一张Q");
			}else if(num==1) {
				System.out.println("电脑出了一张A");
			}else {
				System.out.println("电脑出了一张K");
			}
			count++;
			if(count==10) {
				break;
			}
		}
	}
}
