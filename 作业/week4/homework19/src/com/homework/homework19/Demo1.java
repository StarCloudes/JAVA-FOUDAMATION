package com.homework.homework19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//1：取100个随机数，写入到本地文件中，加序号，每写一个换行。
public class Demo1 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new FileWriter("text1.txt",true));
		
	    for (int i = 0; i < 100; i++) {
			bWriter.write(i+ " "+ new Random().nextInt(100));
			bWriter.newLine();
		}
	    
	    bWriter.close();
	}
}
