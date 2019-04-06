package com.qianfeng.homework;

import java.util.Random;

public class hwork7 {
	public static void main(String[] args) {
		long startTime, endTime;
		startTime = System.currentTimeMillis();//����һ��������ʱ���������Ȼ���ӡʱ���
		addWordStr();
		endTime = System.currentTimeMillis();
		System.out.println("String����ʱ�䣺" +(endTime-startTime) +  "����");
		
		startTime = System.currentTimeMillis();//���ڶ���������ʱ���������Ȼ���ӡʱ���
		addWordBuf();
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer����ʱ�䣺" +(endTime-startTime) +  "����");
	}
	
	public static String randWord() {//����������������ɵ��ʵģ���ʵ�����������5����ĸ����������������ĵ��ʻ����в���
		Random random = new Random();
		
		char[] word = new char[5];
		
		for(int i = 0; i < 5; i++) {
			word[i] = (char)(random.nextInt(26)+65);
		}
		//System.out.println(word);
		return new String(word);
	}
	
	public static void addWordStr() {//��String�����10000������
		String str = "";
		for(int i = 0; i < 10000; i++) {
			str += randWord();
		}
	}
	
	public static void addWordBuf() {//��StringBuffer�����10000������
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < 10000; i++) {
			buffer.append(randWord());
		}
		
	}
}
