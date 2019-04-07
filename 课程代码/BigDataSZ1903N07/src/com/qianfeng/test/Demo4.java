package com.qianfeng.test;

public class Demo4 {
	public static void main(String[] args) {
		/*
		 * 类与类之间的关系
		 * 组合:可以使用谁拥有谁描述
		 * 传参:
		 * 继承:可以使用谁是谁描述
		 */
	}
}

class Person1{
	String name;
	Cat cat;
	//一个类型一旦创建出来,就是一个独立的数据类型,在他可见的范围内都是可以使用的,包括自己的内部.
	Person1 baby;
	
	public void feed(Cat cat) {
		
	}
}

class Cat{
	String name;
	
	Person1 person1;
}
