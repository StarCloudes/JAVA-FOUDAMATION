package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

/*
 * 实现大小写转换的服务器--TCP
 * 
 * 客户端
 * 
 * 这里最好都不要使用缓冲流等进行封装,就使用原始的流.否则在进行读写的时候,不能正确的在客户端与服务器端之间响应
 * 如果使用了缓冲流等,要使用打印流的println,printf等方法,并且打印流要使用new PrintWriter(OutputStream o,boolean b)
 * 并且b=true
 */
public class Demo9 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建Socket对象并绑定服务器的地址和端口
		Socket socket = new Socket(InetAddress.getLocalHost(), 22200);
		
		//2.准备数据---实现让用户从控制台输入
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
		//3.获取socket内部的输出流
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream,true);//当第二个参数为true的时候,会自动刷新,
																	//只有调用println/printf方法是起作用.
		//4.将数据写入网络
		
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
        
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
			printWriter.println(data);

			//当输入over的时候,代表结束
			if ("over".equals(data)) {
				break;
			}
			
			//接收从服务器传回的数据
			//将内容写到控制台
			String data2 = bufferedReader2.readLine();
			System.out.println("data1:"+data2);
		}
		
		//5.关闭资源
		bufferedReader.close();
		bufferedReader2.close();
		printWriter.close();
		socket.close();
	}
}

