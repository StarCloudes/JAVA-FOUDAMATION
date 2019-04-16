package com.qianfeng.test;
//网络通信----socket通信:TCP/UDP

import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/* 客户端:(app/浏览器)
* 服务器端:!=主机
* 
* 端口号:同一台主机上的每一个服务器都拥有自己的端口号,取值范围(0,65535),常用的端口:80,8080
* 注意点:1.要保证客户端和服务器端的端口号一致    2.要保证同一台主机上的不同服务器端口号不同
* 
** TCP与UDP的区别:
 * 		TCP                             UDP
 * 1.是建立在连接的基础上                                 建立在非连接的基础上
 * 2.安全性更高							安全性低
 * 3.传输速度低							速度高
 * 4.适合传输数据量大的数据    				数据量小的数据
* */
//模拟UDP通信
//客户端
/*
 * 1.创建UDP通信的对象-socket对象:对应的类是DatagramSocket.(用于UDP数据的发送与接收)
 * 2.数据的准备-封装包:DatagramPacket(数据包,包括相关的属性,数据)
 * 3.发送数据,通过send方法
 * 4.关闭socket对象
 */
public class Demo3 {
	public static void main(String[] args) throws IOException {	
//		 * 1.创建UDP通信的对象-socket对象:对应的类是DatagramSocket.(用于UDP数据的发送与接收)
		DatagramSocket datagramSocket = new DatagramSocket();
//		 * 2.数据的准备-封装包:DatagramPacket(数据包,包括相关的属性,数据)
		 /* 打包
		 * 参数一:要传输的数据
		 * 参数二:数据的长度
		 * 参数三:服务器所在主机的地址
		 * 参数四:服务器的端口
		 */
		byte[] buf = "bingbing".getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 20000);
//		 * 3.发送数据,通过send方法
		datagramSocket.send(packet);
//		 * 4.关闭socket对象
		datagramSocket.close();
		 
	}
}
