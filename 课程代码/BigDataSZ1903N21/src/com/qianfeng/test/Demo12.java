package com.qianfeng.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * URL:统一资源定位器
 * URI:统一资源定位符
 * 
 * URL的功能:可以通过它的方法直接获取网址的各个部分,还可以访问网络的资源
 * 
 * 明天内容:
 * 1.socket通信
 * 2.正则表达式
 * 3.反射
 * 4.动态代理
 */
public class Demo12 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.baidu.com:80/a/b/c/d?name=bingbing&age=18");
		//直接获取网址的各个部分
		System.out.println(url.getProtocol());//https 协议
		System.out.println(url.getHost());//域名/IP
		System.out.println(url.getPath());//资源路径
		System.out.println(url.getQuery());//查询条件
		System.out.println(url.getFile());//资源路径+查询条件
		System.out.println(url.getPort());//端口
		System.out.println(url.getDefaultPort());//默认端口
		//System.out.println(url.getContent());//获取请求的内容,当前网址是假的,无法实现请求
		
		
		//访问网络的资源
		URL url2 = new URL("https://www.baidu.com/");
		//URLConnection代表客户端与服务器端的通信通道,这个类的实例可以用于读取或者写入url引入的资源
		URLConnection urlConnection = url2.openConnection();
		//获取URLConnection内部的输入流
		InputStream inputStream = urlConnection.getInputStream();
		
		//读取数据
		byte[] arr = new byte[1000];
		inputStream.read(arr);
		System.out.println(new String(arr));
	}
}
