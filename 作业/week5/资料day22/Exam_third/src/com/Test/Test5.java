package com.Test;

import java.util.Scanner;

//���һ������, �ж�һ�������ǲ���ˮ�ɻ���
public class Test5 {
	public static void main(String[] args) {
		jungleNum();
	}
	public static void jungleNum() {
		System.out.println("������һ����λ����");
		int num = new Scanner(System.in).nextInt();
		String str = String.valueOf(num);
		if(str.length() != 3) {
			System.out.println("��������λ��");
			return;
		}
		
		int sum = 0;
		String[] strs = str.split("");
		for(int i = 0; i<strs.length; i++) {
			sum += Math.pow(Integer.parseInt(strs[i]), 3);	
		}
		if(sum == num) {
			System.out.println(num+"��ˮ�ɻ���");
		}else {
			System.out.println(num+"����ˮ�ɻ���");
		}
		
	}
}
