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
		
		
		while(true) {//��һ��ѭ������һֱ�������Ϸ������Ļ���һ�ѵ�һ�����ǣ�ûɶ��˼
			System.out.println("1.ʯͷ    2.����   3.��    ��������������Ϸ");
			System.out.println("���ȳ�");
			fingerComputer = random.nextInt(3) + 1;
			fingerPlayer = sc.nextLine();
			switch(fingerPlayer) {
			case "1":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("�ҳ�����ʯͷ������ƽ���ˣ�");
					break;
				}
				case 2:{
					System.out.println("�ҳ����Ǽ�������ϲ��Ӯ��");
					break;
				}
				case 3:{
					System.out.println("�ҳ����ǲ���������˼������");
					break;
				}
				
				}
				break;
			}
			case "2":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("�ҳ�����ʯͷ��������˼������");
					break;
				}
				case 2:{
					System.out.println("�ҳ����Ǽ���������ƽ���ˣ�");
					break;
				}
				case 3:{
					System.out.println("�ҳ����ǲ�����ϲ��Ӯ��");
					break;
				}
				}
				break;
			}
			case "3":{
				switch(fingerComputer) {
				case 1:{
					System.out.println("�ҳ�����ʯͷ����ϲ��Ӯ��");
					break;
				}
				case 2:{
					System.out.println("�ҳ����Ǽ�����������˼������");
					break;
				}
				case 3:{
					System.out.println("�ҳ����ǲ�������ƽ���ˣ�");
					break;
				}
				}
				break;
			}
			default :{
				System.out.println("��Ϸ�ѽ����������¿�ʼ��");
				System.exit(0);
			}
			}
			
		}
		
	}
}
