package com.qianfeng.homework;

import java.util.Scanner;

public class hwork2 {
	public static void main(String[] args) {
		if(checkPassword()) {//checkPassword:������뺯��
			System.out.println("����������ȷ�������ѿ���");
		}
	}
	
	public static boolean checkPassword() {
		Scanner sc = new Scanner(System.in);
		String pwd1 = "666666";//��һ������
		String pwd2 = "888888";//�ڶ�������
		
		System.out.println("�������һ�����룺");
		String password = sc.nextLine();
		if(!pwd1.equals(password)) {
			System.out.println("�����������");
			return false;
		}else {
			System.out.println("������ڶ������룺");
			password = sc.nextLine();
			if(!pwd2.equals(password)) {
				System.out.println("�ڶ��������������");
				return false;
			}
			
		}
		return true;
	}
}
