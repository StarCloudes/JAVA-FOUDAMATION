package com.qianfeng.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//服务器端
public class Demo6 {
	public static void main(String[] args) throws IOException {
		System.out.println("启动服务器....,成功.准备接受数据");
//		 * 1.创建socket对象,并绑定端口号---DatagramSocket
		DatagramSocket datagramSocket = new DatagramSocket(20002);
		//不断的接收数据
		while (true) {
	//		 * 2.创建包对象,创建空数组,准备接收传来的数据
			byte[] buf = new byte[100];
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
	//		 * 3.接收数据:当服务器运行起来,让他一直处于监听状态的方法
			datagramSocket.receive(datagramPacket);
			//取数据
			byte[] arr = datagramPacket.getData();
			String data = new String(arr);
			System.out.println(data.trim());
			//当发送over的时候,我们认为结束
			
			if (data.trim().equals("over")) {
				break;
			}
		}
//		 * 4.关闭相关的对象
		datagramSocket.close();
	}
}
