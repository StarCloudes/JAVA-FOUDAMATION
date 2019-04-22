package com.exam.homework22;

public class Demo5 {
	public static void main(String[] args) {
		Saler saler1 =new Saler(21, 01, "zhang", 2000, 4000000);
		Saler saler2 =new Saler(24, 02, "hh", 2000, 40000);
		Saler[] saler = {saler1,saler2};
		Manager manager = new Manager(40, 03, "chen", 300000, 7, saler);
		System.out.println("经理工资："+manager.getSalary());
		manager.manager();
	}

}


class Worker{
	//工龄、工号、姓名、基本工资
	int year;
	int number;
	String name;
	int salary;
	public Worker(int year, int number, String name, int salary) {
		super();
		this.year = year;
		this.number = number;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return "Worker [year=" + year + ", number=" + number + ", name=" + name + ", salary=" + salary + "]";
	}
	
	public int getSalary() {
		return this.salary;
	}
}

class Manager extends Worker{
	Saler[] saler;
	int level;
	
	public Manager(int year, int number, String name, int salary,int level,Saler[] saler) {
		super(year, number, name, salary);
		this.saler = saler;
		this.level = level;
	}
	
	public int getSalary() {
		return this.salary+this.level*500+this.year*1000;
	}
	
	public void manager() {
		for(Saler saler:saler) {
			System.out.println(saler);
		}
	}
}

class Saler extends Worker{
    int sales;
    
	public Saler(int year, int number, String name, int salary,int sales) {
		super(year, number, name, salary);
		this.sales = sales;
	}

	
	@Override
	public String toString() {
		return "Saler [sales=" + sales + ", name=" + name + "]";
	}


	public int getSalary() {
		if(sales > 1000000) {
			return (int) (this.salary+this.sales*0.09);
		}else {
			return (int) (this.salary+this.sales*0.08);
		}
	}
}


class Phone{
	//属性：brand price
	String brand;
	int price;
	
	public Phone(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	
	public String toString() {
		return "Phone [brand=" + brand + ", price=" + price + "]";
	}
}