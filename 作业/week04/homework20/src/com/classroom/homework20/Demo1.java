package com.classroom.homework20;

import java.io.IOException;
import java.io.InputStream;

//研究标注输入流的功能
public class Demo1 {
	public static void main(String[] args) throws IOException {
		InputStream iStream = System.in;
     	myReadLine(iStream);
	}
	
	public static void myReadLine(InputStream iStream) throws IOException {
		StringBuffer sBuffer = new StringBuffer();
		while(true) {
			int num = iStream.read(); //阻塞
			if(num == '\n') {
				System.out.println(sBuffer.toString());
				//结束程序
				if(sBuffer.toString().equals("over")) {
					break;
				}
				//将上一次的输入值清除
				sBuffer.delete(0, sBuffer.length());
			}else {
				sBuffer.append((char)num);
			}
		}
	}

}

