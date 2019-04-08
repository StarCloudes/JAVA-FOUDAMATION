package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 练习:创建一个类:狗类   属性:姓名,年龄
 * 要求:创建一个集合保存3个狗对象,第一个拉布拉多   第二个:金毛   第三:博美,分别根据年龄和姓名去重
 */
public class Lianxi2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add(new Dog("拉布拉多", 20));
		list.add(new Dog("金毛", 20));
		list.add(new Dog("博美", 23));
		list.add(new Dog("金毛", 26));
		System.out.println(list);
		
		ArrayList list1 = new ArrayList<>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (!list1.contains(object)) {
				list1.add(object);
			}
		}
		
		System.out.println(list1);
	}
}

class Dog{
	String name;
	int age;
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	//:按照人的年龄和姓名比较.只要年龄和姓名一致就认为是一个人.
	public boolean equals(Object obj) {
		if (!(obj instanceof Dog)) {
			throw new ClassCastException("对象错误");
		}
		
		//向下转型
		Dog person = (Dog)obj;
		//return this.age==person.age && this.name.equals(person.name);
		//根据年龄比
		//return this.age == person.age;
		//根据姓名
		return this.name.equals(person.name);
	}
}
