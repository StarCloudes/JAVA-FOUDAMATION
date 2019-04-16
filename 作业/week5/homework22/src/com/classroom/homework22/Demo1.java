package com.classroom.homework22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


//Socket
//模拟UDP
/*
 * 1.创建UDP通信的对象-socket对象:对应的类是DatagramSocket.(用于UDP数据的发送与接收)
 * 2.数据的准备-封装包:DatagramPacket(数据包,包括相关的属性,数据)
 * 3.发送数据,通过send方法
 * 4.关闭socket对象
 */

public class Demo1 {
	public static void main(String[] args) throws IOException {
	    DatagramSocket socket = new DatagramSocket();
	    //byte[] buf = "bingbing".getBytes();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String data = bufferedReader.readLine();
		byte[] buf = data.getBytes();
	    DatagramPacket packet = new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(),6000);
	    socket.send(packet);
	    bufferedReader.close();
	    socket.close();	    
	}
}
