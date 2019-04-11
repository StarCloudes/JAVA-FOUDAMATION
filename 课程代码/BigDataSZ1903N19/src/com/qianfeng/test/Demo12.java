package com.qianfeng.test;
/*
 * 字符流:----传输的是字符,只能传输字符
 * 		字符写出流   Writer
 * 			write()  write(字符数组) write(字符串)
 * 		字符读入流   Reader
 * 			read()  read(数组)
 * 		字符缓冲写出流   BufferedWriter
 * 			newline()  跨平台换行
 * 		字符缓冲读入流   BufferedReader
 * 			readLine() 读一行
 * 字节流:---传输的是字节,可以传输任何类型的数据
 * 		字节输出流     OutputStream
 * 		字节输入流     InputStream
 * 		字节缓冲输出流     BufferedOutputStream
 * 		字节缓冲输入流     BufferedInputStream
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo12 {
	public static void main(String[] args) throws IOException {
		//写
		//write();
		//读1
		read1();
		//读2
		read2();
		//读3
		read3();
	}
	//写
	public static void write() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("test4.txt");
		fileOutputStream.write("bingbing".getBytes());//这里只能写字节,这里使用的默认编码
		fileOutputStream.close();
	}
	//读1---一次读一个字节
	public static void read1() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("test4.txt");
		int num = 0;
		while ((num = fileInputStream.read()) != -1) {
			System.out.print((char)num);
		}
		fileInputStream.close();
	}
	//读2---一次读多个字节
	public static void read2() throws IOException {
		byte[] arr = new byte[3];
		FileInputStream fileInputStream = new FileInputStream("test4.txt");
		int num = 0;
		while ((num = fileInputStream.read(arr)) != -1) {
			System.out.print(new String(arr,0,num));
		}
		fileInputStream.close();
	}
	//读3---读全部字节
	public static void read3() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("test4.txt");
		//获取全部的字节数
		//注意:如果文本的字节数太大不建议使用
		int value = fileInputStream.available();
		byte[] arr = new byte[value];
		fileInputStream.read(arr);
		System.out.println(new String(arr));
		fileInputStream.close();
	}
}
