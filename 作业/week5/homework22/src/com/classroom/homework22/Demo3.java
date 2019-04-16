package com.classroom.homework22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Demo3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),20000);
		
		//发送数据
		//String data = "Big data";
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		String data = bfReader.readLine();
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(data.getBytes());
		
		//接受数据
		InputStream inputStream = socket.getInputStream();
		byte[] arr = new byte[100];
		int num = 0;
		num = inputStream.read(arr);
		System.out.println(new String(arr,0,num));
		
		socket.close();
	}
}
