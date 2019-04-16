package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//* 随时发随时收--使用UDP完成
//客户端
public class Demo5 {
	public static void main(String[] args) throws IOException {
//		 * 1.创建UDP通信的对象-socket对象:对应的类是DatagramSocket.(用于UDP数据的发送与接收)
		DatagramSocket datagramSocket = new DatagramSocket();
		//创建缓冲字节读入流实现从键盘接收数据
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String data = null;
		while ((data = bufferedReader.readLine()) != null) {
//			 * 2.数据的准备-封装包:DatagramPacket(数据包,包括相关的属性,数据)
			DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 20002);
//			 * 3.发送数据,通过send方法
			datagramSocket.send(packet);
			
			//当发送over的时候,我们认为结束
			if (data.equals("over")) {
				break;
			}
		}

//		 * 4.关闭socket对象
		datagramSocket.close();
	}
	

}

