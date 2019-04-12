package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Demo7 {
	public static void main(String[] args) throws IOException {
		//更换输入源
		//注意:这里是临时更换,只能在当前程序中使用更换后的输入源输出源,如果在其他的程序中会自动变回原来的输入源输出源
		//从键盘接收数据更替成从文件接收数据
		System.setIn(new FileInputStream("D:\\workspace\\BigDataSZ1903N20\\src\\com\\qianfeng\\test\\Demo1.java"));
		//从输出到控制台更替成输出到文件
		System.setOut(new PrintStream("D:\\workspace\\BigDataSZ1903N20\\Democopy.java"));
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
			bufferedWriter.write(data);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
