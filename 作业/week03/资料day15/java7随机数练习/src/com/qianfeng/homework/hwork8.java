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
		
		int count = 1;//һ��������������ͳ�Ʋ��ִ�����
		
		System.out.println("��ӭ���������Ϸ");
		System.out.println("====================");
		int num = random.nextInt(100)+1;//�������һ������
		System.out.println("�����Ѿ����ɣ���������µ�����1-100");
		int scNum = sc.nextInt();
		if (scNum==num) {
			System.out.println("��ô������һ�¾Ͳ¶��ˣ�");
		}
		else {
			while(scNum!=num) {//һֱ�£�֪���¶ԣ�ѭ������
				if(scNum>num) {
					System.out.println("���ˣ�������");
					scNum = sc.nextInt();
					count++;
				}else {
					System.out.println("С�ˣ�������");
					scNum = sc.nextInt();
					count++;
				}
			}
			System.out.println("����" + count + "�ѾͲ¶��ˣ�����������");
		}
		
	}
}
