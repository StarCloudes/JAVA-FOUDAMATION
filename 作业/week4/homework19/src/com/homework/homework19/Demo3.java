package com.homework.homework19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//将三个java文件的内容写入到一个文件中
public class Demo3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfReader1 = new BufferedReader(new FileReader("test1.txt"));
		BufferedReader bfReader2 = new BufferedReader(new FileReader("test2.txt"));
		BufferedReader bfReader3 = new BufferedReader(new FileReader("text1.txt"));

		BufferedWriter bfWriter = new BufferedWriter(new FileWriter("text3.txt"));

		BufferedReader[] str = { bfReader1, bfReader2, bfReader3 };

		for (int i = 0; i < str.length; i++) {
			String line = null;

			while ((line = str[i].readLine()) != null) {
				bfWriter.write(line);
				bfWriter.newLine();// 写入换行
			}
		}
		
		bfReader1.close();
		bfReader2.close();
		bfReader3.close();
		bfWriter.close();
	}
}
