package com.qianfeng.test;
//服务器

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo4 {
	public static void main(String[] args) throws IOException {
		//服务器端:接收数据
		/*
		 * 1.创建socket对象,并绑定端口号---DatagramSocket
		 * 2.创建包对象,创建空数组,准备接收传来的数据
		 * 3.接收数据
		 * 4.关闭相关的对象
		 */
		System.out.println("启动服务器....,成功.准备接受数据");
//		 * 1.创建socket对象,并绑定端口号---DatagramSocket
		DatagramSocket datagramSocket = new DatagramSocket(20000);
//		 * 2.创建包对象,创建空数组,准备接收传来的数据
		byte[] buf = new byte[100];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
//		 * 3.接收数据:当服务器运行起来,让他一直处于监听状态的方法
		datagramSocket.receive(datagramPacket);
		//取数据
		byte[] arr = datagramPacket.getData();
		System.out.println(new String(arr));
//		 * 4.关闭相关的对象
		datagramSocket.close();
	}
}
