package com.homework.homework15;

import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		if(checkPassword()) {
			System.out.println("成功打开保险箱");
		}
	}
	
	public static boolean checkPassword() {
		Scanner sc = new Scanner(System.in);
		String pwd1 = "666666";
		String pwd2 = "888888";
		
		System.out.println("请输入保险柜密码");
		String password = sc.nextLine();
		if(!pwd1.equals(password)) {
			System.out.println("您的密码错误");
			return false;
		}else {
			System.out.println("请输入第二个密码");
			password = sc.nextLine();
			if(!pwd2.equals(password)) {
				System.out.println("您的第二个密码错误");
				return false;
			}
			
		}
		return true;
	}
}
