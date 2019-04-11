package com.qianfeng.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/*
 * LineNumberReader:是BufferedReader的子类,不能读.但是可以提高效率,特有功能:设置行号,获取行号
 */
public class Demo11 {
	public static void main(String[] args) throws IOException {
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("D:\\workspace/BigDataSZ1903N19\\src\\com\\qianfeng\\test\\Demo1.java"));
		//设置行号,默认从0开始,从1开始打印
		lineNumberReader.setLineNumber(10);
		String data = null;
		while ((data = lineNumberReader.readLine()) != null) {
			System.out.print(lineNumberReader.getLineNumber());//获取行号
			System.out.print(data);
			System.out.println();
		}
		lineNumberReader.close();
	}
}
