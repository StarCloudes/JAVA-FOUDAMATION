package com.qianfeng.sort;

public class homework03 {
	/*
	 * ' 公司中的程序员有姓名,工号,薪水,工作内容 项目经理有姓名,工号,薪水,工作内容,奖金
	 */
	public static void main(String[] args) {
		Programmers pro = new Programmers("张三", "123", 2344.55);
		pro.work();
		Manager manager = new Manager("李四", "123334", 2344.55, 10000000);
		manager.work();
	}
}

abstract class Worker {
	private String name;
	private String id;
	private double salary;

	Worker() {
	}

	Worker(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public abstract void work();
}

class Programmers extends Worker {
	Programmers() {
	}

	Programmers(String name, String id, double salary) {
		super(name, id, salary);
	}

	public void work() {
		System.out.println("写程序");
	}
}

class Manager extends Worker {
	private double bonus;

	Manager() {
	}

	Manager(String name, String id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}

	public void work() {
		System.out.println("管程序员");
	}
}