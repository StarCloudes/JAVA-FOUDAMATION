package com.qianfeng.test;
/*
 * 在类上使用泛型
 */
public class Demo8 {
	public static void main(String[] args) {
		Phone phone = new Phone("华为");
		Computer computer = new Computer("苹果");
		
		//使用泛型前
//		Student student = new Student();
//		student.setTools(phone);//多态
//		Tools tools = student.getTools();
//		Phone phone2 = (Phone)tools;
//		phone2.call();
//		Computer computer2 = (Computer)tools;
		
		//使用泛型后
		Student1<Phone> student = new Student1<Phone>();
		student.setTools(phone);//不需要向下转型
		//student.setTools(computer);
	}
}
//使用泛型后
/*
 * 使用泛型后
 * 给Student类加泛型,方式:在类的后面直接添加<E>,E代表任意一种数据类型,注意:这里不一定是E,任意字母都可以
 * 这就是在类上使用泛型
 * 在类上确定的泛型可以直接在方法上使用
 */
class Student1<F> {
	F tools;
	public F getTools() {
		return tools;
	}
	public void setTools(F tools) {
		this.tools = tools;
	}
}
//使用泛型前
class Student {
	Tools tools;
	public Tools getTools() {
		return tools;
	}
	public void setTools(Tools tools) {
		this.tools = tools;
	}
}

class Tools{
	String name;
}
class Computer extends Tools{
	public Computer() {
	}
	public Computer(String name) {
		this.name = name;
	}
}
class Phone extends Tools{
	public Phone() {
	}
	public Phone(String name) {
		this.name = name;
	}
	public void call() {
		System.out.println("打电话");
	}
}
