package com.classroom.homework19;

import java.io.FileReader;
import java.io.IOException;

//读取  输入流
//显示在控制台 输出流

public class Demo2 {
	public static void main(String[] args) throws IOException {
		
	   FileReader fReader = new FileReader("test2.txt");
	   //每次去读一个字符，返回int型，且每读完一次指针往后移动一位，读完后返回-1
	   int value ;	  
	   while((value = fReader.read()) != -1) {
		   System.out.println((char)value);
	   }
	   fReader.close();
	   
	   //一次读取多个
	   FileReader fReader2 = new FileReader("test2.txt"); 
	   char[] c = new char[2];
	   int num ;  
	   while ((num = fReader2.read(c)) != -1) {
		   System.out.println(new String(c,0,num) + "   num:" + num);
	   }
	   fReader2.close();
	}

}
