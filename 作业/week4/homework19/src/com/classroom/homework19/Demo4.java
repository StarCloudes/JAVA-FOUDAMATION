package com.classroom.homework19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  

public class Demo4 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text4copy.txt"));
		BufferedReader bufferedReader = new BufferedReader(new FileReader("text4.txt"));
		
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {

			bufferedWriter.write(data);
			bufferedWriter.newLine();  //跨平台换行
		}
		
		bufferedWriter.close();
		bufferedReader.close();
	}

}
