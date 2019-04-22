package com.classroom.homework20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//字符转换流   -- 不直接使用，而是使用他们的子类，比如FileReader
//InputStreamReader 字符输入转换流
//OutputStreamWriter 字符输出转换流
public class Demo2 {
    public static void main(String[] args) throws IOException {
		BufferedReader bReader =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String data = null;
		while((data = bReader.readLine()) != null) {
			bWriter.write(data);
			bWriter.newLine();
			bWriter.flush();
		}
		
		bReader.close();
		bWriter.close();
	}
}
