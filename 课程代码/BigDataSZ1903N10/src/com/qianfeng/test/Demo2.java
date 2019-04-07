package com.qianfeng.test;

public class Demo2 {
	public static void main(String[] args) {
		/*
		 * 多态:
		 * 前提一定是多态
		 * 向上转型:相当于自动类型转换,从低类型到高类型,将子类的引用转换成父类的引用,注意:这里说的类型转换描述的是引用
		 * 作用:实现多态
		 * 向下转型:相当于强制类型转换,从高类型到低类型.将父类的引用转成子类的引用.
		 * 作用:实现子类特有方法的调用
		 */
		//向上转型
		Person person = new Student();//多态
		
		//向下转型
		Student student =  (Student)person;
		//person.eat();  Person中没有这个方法
		//student.eat();//实现子类特有方法的调用
		//注意点:
		//1.这是不是父类的引用指向子类的对象,不是向上转型.使用子类的引用指向父类的对象是错误的.
		//Student student2 = new Person();
		//2.这里不是多态,所以不是向下转型
		Person p1 = new Person();
		Student student2 = (Student)p1;
	}
}

class Person{
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println("Person-show");
	}
}

class Teacher extends Person{
	public void play() {
		System.out.println("Teacher-play");
	}
}

class Student extends Person{
	public  void eat() {
		System.out.println("Student-eat");
	}
}