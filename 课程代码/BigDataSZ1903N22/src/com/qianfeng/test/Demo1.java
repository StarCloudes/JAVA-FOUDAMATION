package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {
	/*
	 * 课前练习
	 * 1.将"我们该上课了"写入d:/a/test.txt,然后再拷贝到d:/b/test.txt
		要求:1.使用字符缓冲流
        2.默认a,b,都是不存在的
	 */
	public static void main(String[] args) throws IOException {
		//1.创建a,b路径
		File file1 = new File("d:/a");
		file1.mkdir();
		File file2 = new File("d:/b");
		file2.mkdir();
		//2.现将内容写入d:/a/test.txt
		BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("d:/a/test.txt"));
		bufferedWriter1.write("我们该上课了");
		bufferedWriter1.close();
		//3.再将内容从d:/a/test.txt拷贝到d:/b/test.txt
		BufferedReader bufferedReader2 = new BufferedReader(new FileReader("d:/a/test.txt"));
		BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("d:/b/test.txt"));
		String data = null;
		while ((data = bufferedReader2.readLine()) != null) {
			bufferedWriter2.write(data);
			bufferedWriter2.newLine();
		}
		bufferedReader2.close();
		bufferedWriter2.close();
	}
}
