package com.homework.homework15;

import java.util.Random;
import java.util.Scanner;

public class Demo8 {
	public static void main(String[] args) {
		guessNumber();
	}
	
	public static void guessNumber() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int count = 1;
		
		System.out.println("猜数字游戏");
		System.out.println("====================");
		int num = random.nextInt(100)+1;
		System.out.println("输入猜测值1-100");
		int scNum = sc.nextInt();
		if (scNum==num) {
			System.out.println("恭喜你猜中");
		}
		else {
			while(scNum!=num) {
				if(scNum>num) {
					System.out.println("猜测数字过大");
					scNum = sc.nextInt();
					count++;
				}else {
					System.out.println("猜测数字过小");
					scNum = sc.nextInt();
					count++;
				}
			}
			System.out.println("游戏结束：你一共猜了" + count + "次");
		}		
	}
}
