package com.qianfeng.homework;

import java.util.Random;

public class hwork3 {
	public static void main(String[] args) {
		computerPlayCard();//���õ��Գ��Ƶĺ���
	}
	
	public static void computerPlayCard() {
		Random random =new Random();
		int count = 0;//������һ��countûɶ���ã�ֻ�ǵ�������ѭ����ֹ������CPU��ֱ��쭵�100
		while(true) {
			int num = random.nextInt(13) + 1;//�������1~13����
			if(num<11&&num>1) {
				System.out.println("���Գ���һ��" + num);
			}else if(num == 11) {
				System.out.println("���Գ���һ��J");
			}else if(num == 12) {
				System.out.println("���Գ���һ��Q");
			}else if(num==1) {
				System.out.println("���Գ���һ��A");
			}else {
				System.out.println("���Գ���һ��K");
			}
			count++;
			if(count==100) {//��������������һ��������ûɶ��
				break;
			}
		}
	}
}
