package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Demo12 {
	public static void main(String[] args) throws IOException {
		/*
		 * 字符打印流:
		 * 字符打印流支持的设备:
		 * 1.File类型的文件
		 * 2.字符串类型的文件
		 * 3.字节输出流
		 * 4.字符写出流
		 * 
		 * 注意点:
		 * public PrintWriter(Writer out,
                   boolean autoFlush)
		 * autoFlush - boolean 变量；如果为 true，则 println、printf 或 format 方法将刷新输出缓冲区
		 * 
		 * 下一堂课内容:
		 * 1.Properties----会
		 * 2.序列流,数据类,内存流介绍----了解
		 * 3.流的序列化-----会会
		 * 4.转换流的编码
		 * 5.流中的编码
		 * 6.网络通信
		 * 	>三要素
		 * 	>IP地址类
		 * 	>Socket通信介绍
		 * 	>TCP
		 * 	>UDP
		 */
		//从键盘输入数据
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//写出到控制台
		PrintWriter printWriter = new PrintWriter(System.out);
		//进行读写
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
			printWriter.println(data);
			printWriter.flush();
		}
		bufferedReader.close();
		printWriter.close();
	}
}
