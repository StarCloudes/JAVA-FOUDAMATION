package com.qianfeng.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Demo3{
	/*
	 * 序列流:把多个输入流的内容一次性的打印(操作)---字节流
	 */
	public static void main(String[] args) throws IOException {
		//创建三个输入流
		FileInputStream fileInputStream1 = new FileInputStream("src\\com\\qianfeng\\test\\Demo2.java");
		FileInputStream fileInputStream2 = new FileInputStream("src\\com\\qianfeng\\test\\Demo2.java");
		FileInputStream fileInputStream3 = new FileInputStream("src\\com\\qianfeng\\test\\Demo1.java");
		
		//将三个输入流放入序列流
		//方式一:先放入一个Vector
//		Vector<FileInputStream> vector = new Vector<>();
//		vector.add(fileInputStream1);
//		vector.add(fileInputStream2);
//		vector.add(fileInputStream3);
//		
//		//得到枚举器
//		Enumeration<FileInputStream> e1 = vector.elements();
		
		//方式二:先放入一个list
		ArrayList<FileInputStream> list = new ArrayList<>();
		list.add(fileInputStream1);
		list.add(fileInputStream2);
		list.add(fileInputStream3);
		
		//将集合转换成枚举
		Enumeration<FileInputStream> e2 = Collections.enumeration(list);
		
		//创建序列流对象并关联相关的文件--参数是一个枚举器
		//SequenceInputStream sequenceInputStream = new SequenceInputStream(e1);
		SequenceInputStream sequenceInputStream = new SequenceInputStream(e2);
		
		//创建输出流
		FileOutputStream fileOutputStream = new FileOutputStream("temp2.txt");
		
		//读写
		byte[] arr = new byte[1024];
		int num;
		while ((num = sequenceInputStream.read(arr)) != -1) {
			fileOutputStream.write(arr, 0, num);
			
			fileOutputStream.flush();
		}
		
		sequenceInputStream.close();
		fileOutputStream.close();
		
		
	}
}
