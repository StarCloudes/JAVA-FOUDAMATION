package com.qianfeng.homework;

import java.util.Random;

public class hwork5 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			playCard();//���ó��ƺ���
		}
	}
	public static void playCard() {
		Random random = new Random();
		int num = random.nextInt(13)+1;//�����������ֵ
		if(num < 10&&num>1) {
			System.out.println("���Գ���һ��"+type()+num);
		}else {
			switch(num) {//��ֵ�뻨ɫ����ƴ��
			case 1:System.out.println("���Գ���һ��"+type()+"A");break;
			case 11:System.out.println("���Գ���һ��"+type()+"J");break;
			case 12:System.out.println("���Գ���һ��"+type()+"Q");break;
			case 13:System.out.println("���Գ���һ��"+type()+"K");break;
			}
		}
	}
	public static String type() {
		Random random = new Random();
		int num = random.nextInt(4);
		switch(num) {//����������滨ɫ
		case 0:return "����";
		case 1:return "÷��";
		case 2:return "����";
		default:return "����";
		}
	}
}
