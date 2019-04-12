package com.qianfeng.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 使用字节流实现图片的复制
		 */
		//1.创建字节输入流
		FileInputStream fileInputStream = new FileInputStream("D:\\workspace\\BigDataSZ1903N20\\100.jpg");
		//2.创建字节输出流
		FileOutputStream fileOutputStream  = new FileOutputStream("D:\\workspace\\BigDataSZ1903N20\\100copy.jpg");
		//3.进行读写
		int num = 0;
		while ((num = fileInputStream.read()) != -1) {
			fileOutputStream.write(num);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
}
