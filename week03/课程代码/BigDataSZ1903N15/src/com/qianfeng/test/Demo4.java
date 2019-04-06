package com.qianfeng.test;

import java.util.HashSet;
import java.util.Set;

public class Demo4 {
	public static void main(String[] args) {
		/*
		 * Set:不可重复的,无序的
		 * 	HashSet:底层是哈希表,线程不安全的
		 *  TreeSet:底层是二叉树,线程不安全的
		 *  
		 *  HashSet:
		 * 原理:是通过调用元素的hashCode和equals方法实现去重,首先调用hashCode方法,拿到当前对象的哈希码值,去让两个对象
         * 的哈希码值进行比较,如果不同,直接认为是两个对象,不再去调用equals,如果相同,再继续调用equals方法,返回true认为是
         * 一个对象,返回false认为是两个对象
         * 
          * 实例:使用HashSet实现Person对象的存储
		 * 比较规则自己指定:按照年龄和姓名比,相同认为是一个人
		 * 分析:要重写hashCode和equals方法
		 */
		Set set = new HashSet<>();
		//说明Set本身的add方法内部实现的去重功能,默认调用的是元素的hashCode和equals方法
		//String类已经默认重写了hashCode和equals方法
		set.add("java");
		set.add("iOS");
		set.add("php");
		set.add("python");
		set.add("java");
		System.out.println(set);
		
		Set set1 = new HashSet<>();

		set1.add(new Person1("bingbing", 208));
		set1.add(new Person1("chenchen", 20));
		set1.add(new Person1("zhangsan", 290));
		set1.add(new Person1("chenchen", 20));
	
		System.out.println(set1);
	}
}

class Person1{
	String name;
	int age;
	public Person1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + "]";
	}
	
	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		//自己制定比较规则:根据年龄和姓名比较
		//容错处理
		if (!(obj instanceof Person1)) {
			throw new ClassCastException("当前的对象不是Person1类型的");
		}
		
		//向下转型
		Person1 person = (Person1)obj;
		return this.name.equals(person.name)  && this.age==person.age;
	}
	
	//重写hashCode方法
	@Override
	public int hashCode() {
		return name.hashCode()+age*1000;
	}
}

