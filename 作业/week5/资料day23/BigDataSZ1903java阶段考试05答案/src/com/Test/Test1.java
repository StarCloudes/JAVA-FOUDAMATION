package com.Test;


public class Test1 {
	public static void main(String[] args) {
		String str = "xiaoming,ÄÐ,20Ëê,172cm,65kg,99·Ö";
		String[] stuIfor = str.split(",");
		Student s1 = new Student(stuIfor[0], stuIfor[1], stuIfor[2], stuIfor[3], stuIfor[4], stuIfor[5]);
		System.out.println(s1);
	}
}
class Student{
	String name;
	String sex;
	String age;
	String height;
	String weight;
	String sorce;
	public Student(String name, String sex, String age, String height, String weight, String sorce) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.sorce = sorce;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", sorce=" + sorce + "]";
	};
	
}
