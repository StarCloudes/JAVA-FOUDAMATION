package com.classroom.homework15;

import java.util.HashSet;
import java.util.Set;

//泛型在类的应用

public class Demo2 {
	public static void main(String[] args) {
		
		Phone phone = new Phone("Apple");
		Computer computer = new Computer("Huawei");
		
		Person<Phone> person = new Person<Phone>();
		person.setTools(phone);
		//person.setTools(computer);
		
//		Tools tools = person.getTools();
//		Phone phone2 = (Phone)tools;
//		phone2.call();
//		
//		Computer computer2 = (Computer)tools;
//		
		
    }

}

//在类上确定的泛型可以在方法中使用
class Person<F>{
	F tools;

	public F getTools() {
		return tools;
	}

	public void setTools(F tools) {
		this.tools = tools;
	}	
}


class Tools{
	String name;
}

class Computer extends Tools{
	public Computer(String name) {
		this.name = name;
	}
}

class Phone extends Tools{
	public Phone(String name) {
		this.name = name;
	}
	
	public void call() {
		System.out.println("call");
	}
}
