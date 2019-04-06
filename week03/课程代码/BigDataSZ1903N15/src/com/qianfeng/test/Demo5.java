package com.qianfeng.test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet:可以实现排序和去重
 * 
 *实例:在TreeSet中存入Person1类的对象
 *并按照年龄和姓名实现排序,去重
 *分析:需要实现Comparable接口的compareTo方法
 * 
 */
public class Demo5 {
	public static void main(String[] args) {
		Set set = new TreeSet<>();
   	 /*
   	  * TreeSet的add方法实现的排序,去重.通过调用元素的compareTo方法
   	  * String类已经实现了Comparable接口
   	  */
		set.add("java");
		set.add("iOS");
		set.add("php");
		set.add("python");
		set.add("java");
		System.out.println(set);
		
		Set set1 = new TreeSet<>();

		set1.add(new Person2("bingbing", 290));
		set1.add(new Person2("chenchen", 20));
		set1.add(new Person2("zhangsan", 290));
		set1.add(new Person2("chenchen", 20));
	
		System.out.println(set1);
	}
}

class Person2 implements Comparable{
	String name;
	int age;
	public Person2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		//根据自己制定的规则比较
		//根据年龄和姓名比较
		//容错处理
		if (!(o instanceof Person2)) {
			throw new ClassCastException("当前的对象不是Person2的对象");
		}
		//向下转型
		Person2 person2 = (Person2)o;
		//先比较年龄
		int num = age-person2.age;
		//再比较姓名
		return num == 0?name.compareTo(person2.name) : num;
	}
	
	
}


