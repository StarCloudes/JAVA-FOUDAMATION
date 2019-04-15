package com.classroom.homework21;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//URL 统一资源定位器
//URI 统一资源定位符
public class Demo4 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.baidu.com:80/a/b/c/s?name=bingbing&age=18");
		System.out.println(url.getHost());
		System.out.println(url.getQuery());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		//System.out.println(url.getContent());
		
		URL url2 = new URL("https://www.baidu.com/");
		URLConnection urlConnection = url2.openConnection();
		//获取内部的输入流
		InputStream inputStream =urlConnection.getInputStream();
		
		//读取数据
		byte[] arr = new byte[1024];
		inputStream.read(arr);
		System.out.println(new String(arr));
		
	}
}
