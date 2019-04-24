package com.qianfeng.client;

import java.util.Scanner;

import com.qianfeng.javabean.User;
import com.qianfeng.server.ServerDemo;

public class ClientDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = scanner.nextLine();
		System.out.println("请输入密码:");
		String pwd = scanner.nextLine();
		
		//验证:
		//第一:本地验证
		//第二:网络验证--正确性验证.要把账号,密码传到服务器
		User user =  ServerDemo.findUser1(username,pwd);
		if (user != null) {
			System.out.println("恭喜"+user.getName()+"登录成功");
		}else {
			System.out.println("登录失败,请重新填写账号,密码");
		}
	}
}
