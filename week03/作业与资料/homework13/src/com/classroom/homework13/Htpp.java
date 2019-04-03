package com.classroom.homework13;
import java.util.Arrays;

public class Htpp {
	public static void main(String[] args) {
		String string = new String("http://www.baidu.com:30/sdf/sfs?name=bingbing&age=33");
		validate(string);
		getPort(string);
		getSerch(string);
	}
	
	public static void validate(String s) {
		if(s.startsWith("http")) {
			System.out.println("是http协议");
		}
	}
	
	public static void getPort(String s) {
		String s2 = s.split("//")[1];
		s2 = s2.split("/")[0];
		if(s2.contains(":")) {
			String port = s2.split(":")[1];
			System.out.println("端口为："+ port);
		}else {
			System.out.println("端口为："+ 80);
		}
	}
	
	public static void getSerch(String s) {
		String s3 = s.split("\\?")[1];
		String[] s4 = s3.split("&");
		System.out.println(Arrays.toString(s4));
	}
}
