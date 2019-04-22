package com.homework.homework19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//将java中所有的字符，写入本地文件，每100个一行。0-65535个
public class Demo2 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new FileWriter("text2.txt",true));
		
	    for (int i = 0; i < 65535; i++) {
			bWriter.write((char)i);
			if(i%100 ==0) {
				bWriter.newLine();
			}
		}	    
	    bWriter.close();
	}

}
