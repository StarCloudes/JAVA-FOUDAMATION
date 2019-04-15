package com.qianfeng.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 转换流的编码问题:
 * 中国的字符集:GBK/GB2312
 * 欧洲的:ISO8859-1
 * 通用的:UTF-8
 * 美国的:ASCII
 * 
 * 
 * 编码:将字符串转化成byte序列的过程
 * 解码:是将byte序列转成字符串的过程
 * 编码错误:乱码:在执行读与写的时候,由于使用的字符集不同,造成了编码的错误.
 * 
 * 
 * 举例:GBK编码,ISO8859-1解码      或者     utf-8编码,GBK解码
 * 解决办法:再编码再解码
 */
public class Demo6 {
	public static void main(String[] args) throws IOException {
		//写的时候采用utf-8编码   
		writeData1();
		readData1();//使用utf-8字符集
		readData2();//使用GBK字符集
		
		//写的时候采用GBK编码
		writeData2();
		readData3();//使用utf-8字符集
		readData4();//使用GBK字符集
	}
	
	//写出
	//编码格式是utf8
	public static void writeData1() throws IOException {
		//创建输出流并关联文件   第一个参数是字节输出流     第二个参数是:输出时指定的编码格式
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("utf8.txt"),"utf-8");
		outputStreamWriter.write("冰冰");
		outputStreamWriter.close();
	}
	
	//写出
	//编码格式是GBK
	public static void writeData2() throws IOException {
		//创建输出流并关联文件   第一个参数是字节输出流     第二个参数是:输出时指定的编码格式
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("GBK.txt"),"GBK");//默认GBK
		outputStreamWriter.write("冰冰");
		outputStreamWriter.close();
	}
	
	//读入
	//编码格式是utf8
	public static void readData1() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf8.txt"),"utf-8");
		char[] arr = new char[100];
		int num = inputStreamReader.read(arr);
		System.out.println("readData1:"+new String(arr,0,num));
		
		inputStreamReader.close();
	}
	
	//读入
		//编码格式是GBK
		public static void readData2() throws IOException {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf8.txt"),"GBK");//默认GBK
			char[] arr = new char[100];
			int num = inputStreamReader.read(arr);
			System.out.println("readData2:"+new String(arr,0,num));
			
			inputStreamReader.close();
		}
		
		//读入
		//编码格式是utf8
		public static void readData3() throws IOException {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("GBK.txt"),"utf-8");
			char[] arr = new char[100];
			int num = inputStreamReader.read(arr);
			System.out.println(new String(arr,0,num));
			
			inputStreamReader.close();
		}
		
		//读入
		//编码格式是utf8
		public static void readData4() throws IOException {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("GBK.txt"),"GBK");//默认GBK
			char[] arr = new char[100];
			int num = inputStreamReader.read(arr);
			System.out.println(new String(arr,0,num));
			
			inputStreamReader.close();
		}
}
