package com.qianfeng.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 读内容:
 * 实例:从文件中读取内容,并显示在控制台------FileReader
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		//1.创建文件读入流
		FileReader fileReader = new FileReader("test2.txt");
		//开始读操作
		/*
		 * read():一个字符一个字符的读,每次读出一个字符
		 * read(数组):一次可以读出多个字符   ,数组的作用:每次会将读出的字符临时放到这个数组中
		 */
		//read():一个字符一个字符的读,每次读出一个字符
		//a:将当前的字符读出    b:将当前的指针后移一位
		int  value;
//		value = fileReader.read(); //返回的是数字
//		System.out.println((char)value);
//		value = fileReader.read();
//		System.out.println((char)value);
//		value = fileReader.read();
//		System.out.println((char)value);
//		value = fileReader.read();
//		System.out.println((char)value);
//		value = fileReader.read();
//		System.out.println((char)value);
//		value = fileReader.read();
//		System.out.println(value);
		while ((value = fileReader.read()) != -1) {
			System.out.println((char)value);
		}
		
		fileReader.close();
	}
}
