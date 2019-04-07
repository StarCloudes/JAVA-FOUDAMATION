package com.qianfeng.test;
//为了解释FuShuException构造方法中的参数如何在打印方法中显示.
public class Demo8 {
	public static void main(String[] args) {
		Teacher teacher = new Teacher("除数为负数了");
		teacher.printStackTrace();
	}
}

class Person{//相当于Exception
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String message) {
		super();
		this.message = message;
	}
	public void printStackTrace() {
		System.out.println(this.getMessage());
	}
}

//相当于FuShuException
class Teacher extends Person{

	public Teacher() {
	}

	public Teacher(String message) {
		super(message);
	}
}

