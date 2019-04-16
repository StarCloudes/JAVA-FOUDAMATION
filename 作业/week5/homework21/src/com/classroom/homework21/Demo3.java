package com.classroom.homework21;

import java.io.IOException;
import java.net.InetAddress;

public class Demo3 {
	public static void main(String[] args) throws IOException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress.getHostName());
		System.out.println(inetAddress.getHostAddress());
		
		InetAddress inetAddress2 = InetAddress.getByName("www.google.com");
		System.out.println(inetAddress2.getHostName());
		System.out.println(inetAddress2.getHostAddress());		
	}
}
