package com.practive.code;

public class TestCunDemo {

	public static void main(String[] args) {
		Person p = new Manager();
		p.sing();
		p.printSalary();
	    
	}
}

class Person {
	private int salary = 10000;

	public static void sing() {
		System.out.println("北京欢迎你");
	}

	int getSalary() {
		return salary;
	}

	public void printSalary() {
		System.out.println(salary);
	}
}

class Manager extends Person {
	int salary = 30000;

	public static void sing() {
		System.out.println("黄种人");
	}

	public void printSalary() {
		System.out.println(getSalary());
	}
}