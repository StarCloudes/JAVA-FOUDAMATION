package com.qianfeng.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TCP的服务器端
public class Demo8 {
	public static void main(String[] args) throws IOException {
		//1.创建服务器端的工作对象--ServerSocket对象并设置端口
		ServerSocket serverSocket = new ServerSocket(20004);
		//2.接收从客户端传过来的socket对象----是让服务器端处于监听状态的方法
		Socket socket = serverSocket.accept();
		//3.卸货--调用socket对象的输入流
		InputStream inputStream = socket.getInputStream();
		byte[] arr = new byte[100];
		int num = 0;
		num = inputStream.read(arr);
		System.out.println(new String(arr,0,num));
		
		//将数据回传到客户端
		//发货---调用socket对象的输出流
		String data = "你好,BigData,SZ1903";
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(data.getBytes());
		
		//4.关闭资源
		serverSocket.close();
	}
}
