package com.qianfeng.test;

class Person{
	//属性
	String name;
	int age;
	double height;
	//行为
	public void eat() {
		System.out.println(name+"在吃");
	}
	
	public void callPhone(String tel)
	{
		System.out.println(name+"在播号码:"+tel);
	}
}
public class Demo2 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "bingbing";
		p1.age =19;
		p1.height = 190;
		
		p1.eat();
		
		//同一个类可以创建多个对象,对象之间没有任何关系,互不影响
		Person p2 = new Person();
		p2.name = "zhangsan";
		p2.eat();
		
		
	}
}
