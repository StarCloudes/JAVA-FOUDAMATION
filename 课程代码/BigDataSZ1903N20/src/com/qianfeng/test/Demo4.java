package com.qianfeng.test;

import java.io.IOException;
import java.io.InputStream;

/*
 * 标准输入流:--System.in:“标准”输入流。此流已打开并准备提供输入数据。通常，此流对应于键盘输入或者由主机环境或用户指定的另一个输入源。 
 * 
  * 			输入源:可以发送数据的设备     输出源:可以接收数据的设备
 * 				1.当前的流已经打开并关联了输入源--键盘
 * 				2.如果不想让键盘充当输入源,可以通过setIn进行更换
 * 标准输出流:--System.out
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;//这里已经直接得到了输入流对象,并且已经绑定了键盘,可以直接从键盘接收数据
//		int num = inputStream.read();//是一个阻塞式的方法
//		System.out.println(num);
		/*
		 * 实例:实现从键盘不断接收字符的程序
		 * 要求:一行一行的接收
		 */
		myReadLine(inputStream);
	}
	public static void myReadLine(InputStream inputStream) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		while (true) {
			int num = inputStream.read();
			if (num == '\r') {
				continue;
			}else if (num == '\n') {
				System.out.println(stringBuffer.toString());
				//当用户输入over的时候,结束程序
				if (stringBuffer.toString().equals("over")) {
					break;
				}
				
				//将上一次的值清除掉
				stringBuffer.delete(0, stringBuffer.length());
			}else {
				stringBuffer.append((char)num);
			}
		}
	}
}
