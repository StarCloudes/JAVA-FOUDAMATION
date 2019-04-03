package com.hoemwork.homework14;

import java.util.ArrayList;

//1. 有Student学生实体，包含姓名，班级名称，考试成绩三个属性
//，向集合中添加五个完整的学生对象（包含所有属性值），遍历集合，输出所有学生的信息。

public class Demo3 {
	public static void main(String[] args) {
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

}
