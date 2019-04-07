package com.homework.homework15;

import java.util.Random;
import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) {
		fingerGuessing();
	}
	
	public static void fingerGuessing() {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String fingerPlayer;
		int fingerComputer;
		
		
		while(true) {
			System.out.println("请输入你的选择  1. 石头   2.剪刀   3.布 ");
			System.out.println("游戏开始");
			fingerComputer = random.nextInt(3) + 1;
			fingerPlayer = sc.nextLine();
			switch(fingerPlayer) {
			case "1":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("平局");
					break;
				}
				case 2:{
					System.out.println("你胜利");
					break;
				}
				case 3:{
					System.out.println("电脑胜利");
					break;
				}
				
				}
				break;
			}
			case "2":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("你赢了");
					break;
				}
				case 2:{
					System.out.println("平局");
					break;
				}
				case 3:{
					System.out.println("你输了");
					break;
				}
				}
				break;
			}
			case "3":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("你输了");
					break;
				}
				case 2:{
					System.out.println("你赢了");
					break;
				}
				case 3:{
					System.out.println("平局");
					break;
				}
				}
				break;
			}
			default :{
				System.out.println("游戏结束");
				System.exit(0);
			}
			}
			
		}
		
	}
}
