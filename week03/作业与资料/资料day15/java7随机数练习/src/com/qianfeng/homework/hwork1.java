package com.qianfeng.homework;

import java.util.Scanner;

public class hwork1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�Ƿ��ǻ�Ա��1������0�����ǣ�?");
		int state = sc.nextInt();
		System.out.println("�����빺����");
		int money = sc.nextInt();
		
		double discountMoney = discount(state,money);//���ô��۵ĺ��������ش��ۺ�Ľ��
		if(discountMoney!=-1) {
			System.out.println("���ۺ�Ϊ��" + discountMoney);
		}else {
			//System.out.println("���벻�Ϸ���");
		}
	}
	
	public static double discount(int state,int money) {
		if(state == 0) {//������ǻ�Աֱ�Ӵ�9��
			System.out.println(money*0.9);
			return money*0.9;
		}else if(state == 1) {//����ǻ�Ա���ڵ���200��7.5�ۣ������8��
			if(money >= 200) {
				//System.out.println(money*0.75);
				return money*0.75;
			}else if(money > 0 && money <200) {
				//System.out.println(money*0.8);
				return money*0.8;
			}else {
				System.out.println("������Ϸ���");
				return -1;
			}
		}else {
			System.out.println("��Ա���벻�Ϸ���");
			return -1;
		}
	}
}
