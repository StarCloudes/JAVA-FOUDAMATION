package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 练习:创建一个类:狗类   属性:姓名,年龄
 * 要求:创建一个集合保存3个狗对象,第一个拉布拉多   第二个:金毛   第三:博美,分别根据年龄和姓名去重
 */
public class Demo3 {
	public static void main(String[] args) {
		//实现的功能:根据年龄和姓名比较人
		ArrayList list = new ArrayList<>();
		list.add(new Person("bingbing",20));
		list.add(new Person("bingbing1",250));
		list.add(new Person("bingbing2",206));
		list.add(new Person("bingbing",20));
		list.add(new Person("bingbing4",20));
		System.out.println(list);
		
		//去重
		//让他去存储去重后的数据
		ArrayList list1 = new ArrayList<>();
		//获取第一个list的迭代器
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			
			if (!list1.contains(object)) {
				list1.add(object);
			}
		}
		System.out.println("去重后的结果:"+list1);
	}
}

class Person{
	String name;
	int age;
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
	
	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		//自己制定比较规则:根据年龄和姓名比较
		//容错处理
		if (!(obj instanceof Person)) {
			throw new ClassCastException("当前的对象不是Person类型的");
		}
		
		//向下转型
		Person person = (Person)obj;
		return this.name.equals(person.name)  && this.age==person.age;
	}
}
