package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 了解:
 * 
 * ?:通配符,可以表示一种或几种数据类型
 * 限制上限:<? extends E>:限制的是整个的<>可以取的泛型类型的上限是E,<>中可以取的类型是E及E的子类
 * 限制下限:<? super E>::限制的是整个的<>可以取的泛型类型的下限是E,<>中可以取的类型是E及E的父类
 * 
 * 
 * 讲的是限制上限:<? extends E>
 */
public class Demo11
{
	public static void main(String[] args) {
		//
		ArrayList<Student2> list1 = new ArrayList<>();
		list1.add(new Student2("bingbing", 1));
		//可以传参:因为Student2是Person1的子类,可以实现遍历
		bianli(list1);
		
		ArrayList<Teacher> list2 = new ArrayList<>();
		list2.add(new Teacher("bingbing", 1));
		//可以传参:因为Teacher1是Person1的子类,可以实现遍历
		bianli(list2);
		
		ArrayList<Person4> list3 = new ArrayList<>();
		list3.add(new Person4("bingbing", 1));
		//可以传参
		bianli(list3);
		
		ArrayList<Object> list4 = new ArrayList<>();
		list4.add(new Object());
		//可以传参:因为Object是Person1的父类,不可以实现遍历
		//bianli(list4);
	}
	
	
	public static void bianli(Collection<? extends Person4>  e){
		System.out.println("遍历了");
	}
}

class Person4{
	String name;
	int age;
	public Person4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person4(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person4 [name=" + name + ", age=" + age + "]";
	}
}

class Teacher extends Person4{
	public  Teacher(String name, int age) {
		super(name, age);
	}
}

class Student2 extends Person4{
	public  Student2(String name, int age) {
		super(name, age);
	}
}