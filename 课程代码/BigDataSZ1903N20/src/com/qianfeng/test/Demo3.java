package com.qianfeng.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
	public static void main(String[] args) throws IOException {
		/*
		 * 使用字节缓冲流实现图片的复制
		 */
		//1.创建字节输入流
		FileInputStream fileInputStream = new FileInputStream("D:\\workspace\\BigDataSZ1903N20\\100.jpg");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		//2.创建字节输出流
		FileOutputStream fileOutputStream  = new FileOutputStream("D:\\workspace\\BigDataSZ1903N20\\100copy1.jpg");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		//3.进行读写
		int num = 0;
		while ((num = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(num);
		}

		bufferedInputStream.close();
		bufferedOutputStream.close();
	}
}
