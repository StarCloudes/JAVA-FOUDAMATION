package com.homework.homework16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//1.创建一个Map集合，存入5个学生信息，使用学号和学生基本信息进行对应，
//学生基本信息包括姓名，年龄，专业，遍历输出。

public class Demo1 {
	public static void main(String[] args) {
		Map<String, Student> map = new HashMap<>();
		map.put("01", new Student("beyonce", 26, "english"));
		map.put("02", new Student("adel", 31, "chinese"));
		map.put("03", new Student("ariana", 16, "chemistry"));
		map.put("04", new Student("nicky", 45, "math"));
		map.put("05", new Student("taylor", 18, "computor"));
		
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key =  iterator.next();
			System.out.println("key: " + key +"      value: " + map.get(key));
		}
//		for (String key : map.keySet()) {
//			System.out.println("学号：" + key + "," + map.get(key));
//		}
	}

}

class Student{
	String name;
	int year;
	String major;
	
	public Student(String name, int year,String major){
		this.name = name;
		this.year = year;
		this.major = major;
	}

	@Override
	public String toString() {
		return "学生 [name=" + name + ", year=" + year + ", major=" + major + "]";
	}
		
	
}
