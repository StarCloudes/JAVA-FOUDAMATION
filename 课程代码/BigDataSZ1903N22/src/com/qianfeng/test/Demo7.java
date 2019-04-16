package com.qianfeng.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * TCP:

 * 在客户端与服务器端通信的时候,对于客户端既要进行输入又要进行输出,所以在Socket对象的内部就内置了输入流和输出流,
 * 当进行数据传输的时候,将数据放入socket对象的内部,将socket对象传到服务器端,相当于在客户端与服务器端建立了一个通道,
 * 两端使用同一个socket对象.
 */
//TCP的客户端
public class Demo7 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.创建客户端工作的对象--Socket对象并绑定端口和主机
		Socket socket = new Socket(InetAddress.getLocalHost(), 20004);
		//2.准备数据
		String data = "BigData,SZ1903,你好";
		//3.调用socket内部的输出流向网络写数据
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(data.getBytes());
		
		//客户端接收服务器的数据
		InputStream inputStream = socket.getInputStream();
		byte[] arr = new byte[100];
		int num = 0;
		num = inputStream.read(arr);
		System.out.println(new String(arr,0,num));
		
		//4.关闭资源
		socket.close();
	}
}
