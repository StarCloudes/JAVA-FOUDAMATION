package com.qianfeng.test;

public class Demo111 {
	public static void main(String[] args) {
		Zi zi = new Zi();
		zi.test();
	}
}

class Fu{
	 int age=12;
	
}
class Zi extends Fu{
	int age=8;
	public Zi() {
		
	}
	public void test() {
		System.out.println(super.age);
	}
}
