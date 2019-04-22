package com.homework.homework17;

import java.util.Random;

//一个线程打印0-9的随机数字，一个线程打印随机的26个小写字母。
public class Homework1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i< 5;i++) {
					int num = new Random().nextInt(10);
					System.out.println(num);
				}
			}
		}).start();	
		
		new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i< 5;i++) {
					int num = new Random().nextInt(26) + 97;
					System.out.println((char)num);
				}
			}
		}).start();	
	}
}


