package com.qianfeng.homework;

import java.util.Random;
import java.util.Scanner;

public class hwork4 {
	public static void main(String[] args) {
		fingerGuessing();
	}
	
	public static void fingerGuessing() {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String fingerPlayer;
		int fingerComputer;
		
		
		while(true) {//用一个循环可以一直玩这个游戏，否则的话玩一把点一下三角，没啥意思
			System.out.println("1.石头    2.剪刀   3.布    其他键：结束游戏");
			System.out.println("你先出");
			fingerComputer = random.nextInt(3) + 1;
			fingerPlayer = sc.nextLine();
			switch(fingerPlayer) {
			case "1":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("我出的是石头，所以平局了！");
					break;
				}
				case 2:{
					System.out.println("我出的是剪刀，恭喜你赢了");
					break;
				}
				case 3:{
					System.out.println("我出的是布，不好意思你输了");
					break;
				}
				
				}
				break;
			}
			case "2":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("我出的是石头，不好意思你输了");
					break;
				}
				case 2:{
					System.out.println("我出的是剪刀，所以平局了！");
					break;
				}
				case 3:{
					System.out.println("我出的是布，恭喜你赢了");
					break;
				}
				}
				break;
			}
			case "3":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("我出的是石头，恭喜你赢了");
					break;
				}
				case 2:{
					System.out.println("我出的是剪刀，不好意思你输了");
					break;
				}
				case 3:{
					System.out.println("我出的是布，所以平局了！");
					break;
				}
				}
				break;
			}
			default :{
				System.out.println("游戏已结束，请重新开始！");
				System.exit(0);
			}
			}
			
		}
		
	}
}
