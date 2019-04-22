package com.classroom.homework22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//服务器端:接收数据
/*
 * 1.创建socket对象,并绑定端口号---DatagramPacket
 * 2.创建包对象,创建空数组,准备接收传来的数据
 * 3.接收数据
 * 4.关闭相关的对象
 */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6000);
		byte[] buf = new byte[100];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

		socket.receive(datagramPacket);// 让服务器一直处于监听状态
		byte[] arr = datagramPacket.getData();
		System.out.println(new String(arr));

		socket.close();
	}

}
