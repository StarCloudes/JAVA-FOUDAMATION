package com.classroom28.cleint;

import com.classroom28.javabean.User;
import com.classroom28.server.ServerDemo;

public class ClientDemo {
   public static void main(String[] args) {
	 String username = "chenchen";
	 String password = "' or 1='1 ";
	 
	 User user = ServerDemo.findUser(username,password);
	 if(user != null) {
		 System.out.println(user.getName() + ",Login success");
	 } else {
		 System.out.println("Login fail");
	 }
 }
}
