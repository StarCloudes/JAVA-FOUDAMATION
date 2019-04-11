package com.qianfeng.test;
/*
 * 实例:完成文件的复制
 * 
 * D:\workspace\BigDataSZ1903N19\src\com\qianfeng\test\Demo1.java:绝对路径
 * BigDataSZ1903N19\src\com\qianfeng\test\Demo1.java:相对路径
 * 
 * 相对路径:从路径中间的某个部位开始一直到当前的文件
 * 绝对路径:一个文件的完整路径,从根目录开始到当前的文件
 * 
 * 补充知识:
 * \代表转义字符      \t:制表符     \n换行符    \\:表示普通的\
 * 在代表路径的时候,\\与/是一个意思.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo6 {
	public static void main(String[] args) throws IOException {
		//1.创建读入流和写出流
		FileReader fileReader = new FileReader("D:\\workspace/BigDataSZ1903N19\\src\\com\\qianfeng\\test\\Demo1.java");
		FileWriter fileWriter = new FileWriter("Demo1copy.java");
		
		//读写
		//使用一次读一个
		int num =0 ;
//		while ((num = fileReader.read()) != -1) {
//			fileWriter.write(num);//可以实现自动转换
//			fileWriter.flush();
//		}
		
		//使用一次读多行
		char[] arr = new char[10];
		while ((num = fileReader.read(arr)) != -1) {
			fileWriter.write(arr,0,num);//可以实现自动转换
			fileWriter.flush();
		}
		
		fileReader.close();
		fileWriter.close();
	}
}
