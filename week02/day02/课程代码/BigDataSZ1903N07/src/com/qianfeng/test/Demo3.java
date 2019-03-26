package com.qianfeng.test;

public class Demo3 {
	public static void main(String[] args) {
		//多个引用指向同一个对象
		Dog dog1 = new Dog();
		dog1.name = "拉布拉多";
		
		Dog dog2 = new Dog();
		dog2.name = "金毛";
		
		Dog dog3 = new Dog();
		dog3 = dog1;
		dog1 = dog2;
		
		System.out.println(dog3.name);
	}
}

class Dog{
	String name;
	int age;
	
	public void eat() {
		
	}
}
