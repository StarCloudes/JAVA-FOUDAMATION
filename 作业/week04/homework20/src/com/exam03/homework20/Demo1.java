package com.exam03.homework20;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter("hello.txt"));
		bWriter.write("hellojava你好");
		bWriter.close();
	}

}
