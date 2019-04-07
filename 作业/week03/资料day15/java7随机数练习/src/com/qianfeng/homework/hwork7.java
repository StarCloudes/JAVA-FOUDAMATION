package com.qianfeng.homework;

import java.util.Random;

public class hwork7 {
	public static void main(String[] args) {
		long startTime, endTime;
		startTime = System.currentTimeMillis();//将第一个程序用时间包起来，然后打印时间差
		addWordStr();
		endTime = System.currentTimeMillis();
		System.out.println("String花费时间：" +(endTime-startTime) +  "毫秒");
		
		startTime = System.currentTimeMillis();//将第二个程序用时间包起来，然后打印时间差
		addWordBuf();
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer花费时间：" +(endTime-startTime) +  "毫秒");
	}
	
	public static String randWord() {//这个函数是用来生成单词的，其实就是随机生成5个字母组合起来，和真正的单词还是有差距的
		Random random = new Random();
		
		char[] word = new char[5];
		
		for(int i = 0; i < 5; i++) {
			word[i] = (char)(random.nextInt(26)+65);
		}
		//System.out.println(word);
		return new String(word);
	}
	
	public static void addWordStr() {//往String中添加10000个单词
		String str = "";
		for(int i = 0; i < 10000; i++) {
			str += randWord();
		}
	}
	
	public static void addWordBuf() {//往StringBuffer中添加10000个单词
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < 10000; i++) {
			buffer.append(randWord());
		}
		
	}
}
