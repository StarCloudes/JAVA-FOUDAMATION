package com.hoemwork.homework13;

public class Dervied extends Base {
	private String name = "dervied";

	public Dervied() {

		tellName();
		printName();
	}

	public void tellName() {
		System.out.println("Dervied tell name: " + name);
	}

	public void printName() {
		System.out.println("Dervied print name: " + name);
	}

	public static void main(String[] args) {
		new Dervied();// 1.执行父类的构造方法 2.给自己的成员变量赋值 3。调用构造方法中的调用的方法
	}
}

class Base {
	private String name = "base";

	public Base() {
		tellName();
		printName();
	}

	public void tellName() {
		System.out.println("Base tell name: " + name);
	}

	public void printName() {
		System.out.println("Base print name: " + name);
	}
}