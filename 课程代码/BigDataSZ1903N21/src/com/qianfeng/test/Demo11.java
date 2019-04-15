package com.qianfeng.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo11 {
	public static void main(String[] args) throws UnknownHostException {
		/*
		 * InetAddress:对IP地址的封装形成的类
		 */
		//获取本机的地址
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress.getHostName());//D5B5
		System.out.println(inetAddress.getHostAddress());//10.36.142.12
		
		//获取网络上任意一台主机的信息
		InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
		System.out.println(inetAddress2.getHostName());//www.baidu.com
		System.out.println(inetAddress2.getHostAddress());//14.215.177.38
	}
}
