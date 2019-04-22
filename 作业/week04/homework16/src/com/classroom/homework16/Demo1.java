package com.classroom.homework16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo1 {
	
    public static void main(String[] args) {
		//test();
		//bianli();
    	//重写hashCode equals 
    	//作业1 hashmap实现字符串和person对象的去重
    	//2 实现栈
    	//3 使用treemap的默认方法和手动方法去实现比较
    	//4 转换成字符串得到个数 区分大小写 只读字母
        hashmap();
		
		
	}
    public static void hashmap() {
    	Map<String, String> map = new HashMap<>();//hashMap底层实现：数组 链表 二叉树 比较：hashTable线程安全
		map.put("01", "java");
		map.put("02", "php");
		map.put("03", "ios");
		map.put("04", "python");
		map.put("04", "javascript");
		System.out.println(map);
	}
    
    public static void bianli() {
    	Map<String, String> map = new HashMap<>();
		map.put("01", "java");
		map.put("02", "php");
		map.put("03", "ios");
		map.put("04", "python");
		
		//遍历1 keySet
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			//System.out.println("key: " + key+ "  value:" + map.get(key));
		}
		
		//遍历2 entrySet
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry<String,String> entry =  iterator2.next();
			System.out.println("key: " + entry.getKey()+ "  value:" + entry.getValue());
		}
	}
    
    public static void test() {
    	Map<String, String> map = new HashMap<>();
		map.put("01", "java");
		map.put("02", "php");
		
		System.out.println(map.put("01", "ios"));
		System.out.println(map);
		
		//map.clear();
		System.out.println(map.get("01"));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
	}

}

class Person{
	String name;
	int age;
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public int hashCode() {
		return name.hashCode() + age* 1000;
	}
	
	public boolean equals(Object obj) {
		if(! (obj instanceof Person)) {
			throw new ClassCastException("当前的对象不是Person1类型的");
		}
		
		Person p = (Person)obj;
		return this.name.equals(p) && this.age == p.age;
	}
}

