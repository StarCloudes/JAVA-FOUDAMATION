package com.qianfeng.test;

import java.util.TreeMap;

/*
 * TreeMap的注意点:
 * 1.什么类型的数据类型可以作为key?
 * a:实现了Comparable接口的compareTo()方法   b:实现了Comparator接口的compare()方法
 * 可以的代表:String,包装类,自定义的实现了要求的类
 * 不可以的代表:数组,ArrayList,LinkedList(如果给他们建立的比较器也可以比较,但是不建议使用)
 * 
 * 2.元素可不可以作为key,跟元素内部的成员有没有关系
 */
public class Demo6 {
	public static void main(String[] args) {
		TreeMap<Cat, String> map = new TreeMap<>();
		map.put(new Cat(), "haha");
	}
}

class Cat implements Comparable<Cat>{
	// * 2.元素可不可以作为key,跟元素内部的成员有没有关系
	Object obj;

	@Override
	public int compareTo(Cat o) {
		
		return 0;
	}
	
}
