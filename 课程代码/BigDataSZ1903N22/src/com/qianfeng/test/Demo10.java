package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class Demo10 {
	public static void main(String[] args) throws IOException {
		//1.创建ServerSocket对象并绑定接口
		ServerSocket serverSocket  = new ServerSocket(22200);
		
		//2.接收套接字的连接,保证客户端与服务器端使用同一个socket对象---一直处于监听的状态
		Socket socket =  serverSocket.accept();
		
		//3.获取输入流
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//获取输出流
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
		
		
		//读写过程
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
			//打印到控制台
			System.out.println(data.toUpperCase());
			
			//实现将服务器的数据写回客户端
			//这里必须使用println,不能用print
			printWriter.println(data.toUpperCase());
			
			System.out.println("haha");
			
			//当输入over的时候,代表结束
			if ("over".equals(data)) {
				break;
			}
		}
		
		//5.关闭资源
		bufferedReader.close();
		printWriter.close();
		serverSocket.close();
	}
}

