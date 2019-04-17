package com.qianfeng.test;

public class Person {
	private String name;
	private int age;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//非静态无参数
	public void show() {
		System.out.println("show");
	}
	//非静态有参数
	public void callPhone(String tel) {
		System.out.println("打电话:"+tel);
	}
	//静态有参数
	public static void run(int num) {
		System.out.println("run:"+num);
	}
	
}
