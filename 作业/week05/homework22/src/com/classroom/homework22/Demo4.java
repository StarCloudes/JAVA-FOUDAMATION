package com.classroom.homework22;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo4 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(20000);
		Socket socket = serverSocket.accept();//让服务器端监听
		
		//读取数据
		InputStream inputStream = socket.getInputStream();
		byte[] arr = new byte[100];
		int num = 0;
		num = inputStream.read(arr);
		System.out.println(new String(arr,0,num));
				
		//发送数据
		String data = new String(arr,0,num).toUpperCase();
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(data.getBytes());		
		
		serverSocket.close();
	}

}
