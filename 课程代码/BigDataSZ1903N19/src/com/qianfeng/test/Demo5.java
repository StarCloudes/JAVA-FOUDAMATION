package com.qianfeng.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//read(数组):一次可以读出多个字符   ,数组的作用:每次会将读出的字符临时放到这个数组中
public class Demo5 {
	public static void main(String[] args) throws IOException {
		//1.创建文件读入流
		FileReader fileReader = new FileReader("test2.txt");
		//开始读操作
		/*
		 * read():一个字符一个字符的读,每次读出一个字符
		 * read(数组):一次可以读出多个字符   ,数组的作用:每次会将读出的字符临时放到这个数组中
		 */
		//read(数组):一次可以读出多个字符   ,数组的作用:每次会将读出的字符临时放到这个数组中
		/* 数组是临时存放数据的地方,我们会将读到的字符放到临时数组中,数组的大小决定了我们一次可以读到的字符个数.
		 * 一般这个数组的大小<=1kB
		 * 返回值代表本次读到的真实的字符个数,如果返回值是-1代表读完了.
		 */
		char[] cbuf = new char[2];
		int num ;
//		num = fileReader.read(cbuf);
//		System.out.println(new String(cbuf)+"    num:"+num);
//		num = fileReader.read(cbuf);
//		System.out.println(new String(cbuf)+"    num:"+num);
//		num = fileReader.read(cbuf);
		//将数组的从下标0开始到num长度个字符取出并转化成字符串
//		System.out.println(new String(cbuf,0,num)+"    num:"+num);
//		num = fileReader.read(cbuf);
//		System.out.println(new String(cbuf)+"    num:"+num);//返回 -1 说明读完了
		
		while ((num = fileReader.read(cbuf)) != -1) {
			//System.out.println(new String(cbuf)+"    num:"+num);
			System.out.println(new String(cbuf,0,num)+"    num:"+num);
		}
		fileReader.close();
	}
}
