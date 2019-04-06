package com.hoemwork.homework14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//1. 有Student学生实体，包含姓名，班级名称，考试成绩三个属性
//，向集合中添加五个完整的学生对象（包含所有属性值），遍历集合，输出所有学生的信息。

public class Demo3 {
	public static void main(String[] args) {
		//arraylist();
	    //hashSet();
	    treeSet();
	    
	}
	
	public static void arraylist() {
		ArrayList list = new ArrayList<>();
		list.add(new Student("jack", "一班", 87.5));
		list.add(new Student("rose", "一班", 92));
		list.add(new Student("tom", "一班", 66.5));
		list.add(new Student("jerry", "一班", 93));
		list.add(new Student("steven", "一班", 80));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void hashSet() {
		Set set = new HashSet<>();
		set.add(new Student("jack", "一班", 87.5));
		set.add(new Student("rose", "一班", 92));
		set.add(new Student("tom", "一班", 66.5));
		set.add(new Student("tom", "一班", 66.5));
		
		System.out.println(set);
	}
	
	public static void treeSet() {
		Set set = new TreeSet<>();
		set.add(new Student("jack", "一班", 87.5));
		set.add(new Student("rose", "一班", 92));
		set.add(new Student("tom", "一班", 87.5));
		set.add(new Student("tom", "一班", 66.5));
		
		System.out.println(set);
	}

}

class Student {

	public Student(String name, String className, double score) {
		this.name = name;
		this.className = className;
		this.score = score;
	}

	private String name;
	private String className;
	private Double score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", className=" + className + ", score=" + score + "]";
	}
	
	public boolean equals(Object object) {
		if(!(object instanceof Student)) {
			throw new ClassCastException("Not person");
		}
		
		Student student =(Student)object;
		return this.name.equals(student.name)&&this.name.equals(student.name);
	}
	
	public int hashCode() {
		return (int) (name.hashCode()+score*1000);
	}
	
	public int compareTo(Object object) {
		//制定比较规则
		if(!(object instanceof Student)) {
			throw new ClassCastException("Not person");
		}
		
		Student student =(Student)object;
		double num = score - student.score;
		return (int) (num == 0? name.compareTo(student.name):num);
	}
	

}
