package com.homework.homework16;

import java.util.HashMap;
import java.util.Map;

//1：假如有以下email数据“aa@sohu.com,bb@163.com,cc@sina.com”现需要把email中的用户部分
//和邮件地址部分分离，分离后以键值对应的方式放入HashMap？
public class Demo4 {
	public static void main(String[] args) {
		String[] emails = new String[3];
		emails[0] = "aa@sohu.com";
		emails[1] = "bb@sohu.com";
		emails[2] = "cc@sohu.com";
		
		Map<String, String> map = new HashMap<String, String>();
		for(String email: emails) {			
			map.put(email.split("@")[0],email.split("@")[1]);
		}
		
		for(String user: map.keySet()) {
			System.out.println("UserName: "+user+"  Email Address: "+map.get(user));
		}
	}
}
