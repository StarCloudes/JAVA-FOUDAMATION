package com.qianfeng.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Demo8 {
	public static void main(String[] args) throws IOException {
		//字符串冲读入流完成读
		BufferedReader bufferedReader = new BufferedReader(new FileReader("test3.txt"));
		
		//读一个
		int num = 0;
/*		while ((num = bufferedReader.read()) != -1) {
			System.out.print((char)num);
		}*/
        
		//一次读多个
/*		char[] arr = new char[10];
		while ((num = bufferedReader.read(arr)) != -1) {
			System.out.print(new String(arr,0,num));
		}*/
		
		//一次读一行  readline()
		//原理:一个字符一个字符的读,直到读到换行符为止.然后将所有读到的字符返回
		//注意点:不会将当前的换行符返回 ;返回值就是我们读到的内容.如果读完了,返回null
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
			System.out.print(data);
			System.out.println();
		}
		bufferedReader.close();
	}
}
