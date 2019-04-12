package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 转换流:实现的是从字节流到字符流,本身是字符流
 * 模拟的场景:使用字符缓冲流的readline和newline方法实现字节流的功能
 * 
 * InputStreamReader:输入转换流
 * OutputStreamWriter:输出转换流
 */
public class Demo5 {
	public static void main(String[] args) throws IOException {
		//由标准输入流得到字符缓冲读入流
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//由标准输出流得到字符缓冲写出流
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		//读写--一次读一行
		String data  = null;
		while ((data = bufferedReader.readLine()) != null) {
			bufferedWriter.write(data);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			if (data.equals("over")) {
				break;
			}
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
