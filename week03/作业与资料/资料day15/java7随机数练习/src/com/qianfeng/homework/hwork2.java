package com.qianfeng.homework;

import java.util.Scanner;

public class hwork2 {
	public static void main(String[] args) {
		if(checkPassword()) {//checkPassword:检测密码函数
			System.out.println("密码输入正确，大门已开！");
		}
	}
	
	public static boolean checkPassword() {
		Scanner sc = new Scanner(System.in);
		String pwd1 = "666666";//第一个密码
		String pwd2 = "888888";//第二个密码
		
		System.out.println("请输入第一个密码：");
		String password = sc.nextLine();
		if(!pwd1.equals(password)) {
			System.out.println("密码输入错误！");
			return false;
		}else {
			System.out.println("请输入第二个密码：");
			password = sc.nextLine();
			if(!pwd2.equals(password)) {
				System.out.println("第二个密码输入错误！");
				return false;
			}
			
		}
		return true;
	}
}
