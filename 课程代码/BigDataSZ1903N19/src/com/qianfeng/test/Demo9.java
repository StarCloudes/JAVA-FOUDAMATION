package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo9 {
	public static void main(String[] args) throws IOException {
		/*
		 * 使用字符缓冲流完成文件的复制
		 */
		//1.创建读入流和写出流
		FileReader fileReader = new FileReader("D:\\workspace/BigDataSZ1903N19\\src\\com\\qianfeng\\test\\Demo1.java");
		FileWriter fileWriter = new FileWriter("Demo1copy.java");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//读写
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
			bufferedWriter.write(data);
			bufferedWriter.newLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
