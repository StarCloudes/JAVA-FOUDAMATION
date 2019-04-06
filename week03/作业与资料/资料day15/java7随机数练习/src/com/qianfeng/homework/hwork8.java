package com.qianfeng.homework;

import java.util.Random;
import java.util.Scanner;

public class hwork8 {
	public static void main(String[] args) {
		guessNumber();
	}
	
	public static void guessNumber() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int count = 1;//一个计数器，用来统计猜字次数的
		
		System.out.println("欢迎来玩猜字游戏");
		System.out.println("====================");
		int num = random.nextInt(100)+1;//随机生成一个数字
		System.out.println("数字已经生成，请输入你猜的数字1-100");
		int scNum = sc.nextInt();
		if (scNum==num) {
			System.out.println("这么厉害，一下就猜对了！");
		}
		else {
			while(scNum!=num) {//一直猜，知道猜对，循环结束
				if(scNum>num) {
					System.out.println("大了，请重输");
					scNum = sc.nextInt();
					count++;
				}else {
					System.out.println("小了，请重输");
					scNum = sc.nextInt();
					count++;
				}
			}
			System.out.println("猜了" + count + "把就猜对了，还不错！！！");
		}
		
	}
}
