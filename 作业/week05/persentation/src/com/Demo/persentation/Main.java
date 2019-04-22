package com.Demo.persentation;

public class Main {	
	public static void main(String[] args) {
		// 首先我们需要一个员工
		Worker worker = new Worker();
 
		// 其次把这个员工指派给总经理
		new Manager(worker);
	}
}
