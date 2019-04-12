package com.qianfeng.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 打印流:
 * 字节打印流:PrintStream:除了拥有输出流的特点之外,还有打印的功能.
 * 字符打印流:PrintWriter
 * 
 * 字节打印流支持的设备:
 * 1.File类型的文件
 * 2.字符串类型的文件
 * 3.字节输出流
 */
public class Demo11 {
	public static void main(String[] args) throws IOException {
		//1.File类型的文件
		PrintStream printStream1 = new PrintStream(new File("D:\\workspace\\BigDataSZ1903N20\\test2.txt"));
		//2.字符串类型的文件
		PrintStream printStream2 = new PrintStream("D:\\workspace\\BigDataSZ1903N20\\test2.txt");
		//3.字节输出流
		PrintStream printStream3 = new PrintStream(new FileOutputStream("D:\\workspace\\BigDataSZ1903N20\\test2.txt"));
		printStream3.println("haha");
		
		printStream1.close();
		printStream2.close();
		printStream3.close();
		//
		PrintStream printStream4 = new PrintStream("test2.txt");
		printStream4.write(97);//00000000 0000000 00000000 01100001    a  打印时将前面三个字节砍掉了
		printStream4.write(353);//00000000 00000000 00000001 01100001    a
		//printStream4.print(353);//相当于内部进行了自用的转化
		//现将353转成字符串,再转成字节数组
		printStream4.write(String.valueOf(353).getBytes());
		printStream4.close();
	}
}
