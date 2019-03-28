package com.qianfeng.sort;

class Car {
	int doors;
	String color;

	public Car() {

	}

	public Car(int doors, String color) {
		this.doors = doors;
		this.color = color;

	}

}

class BW extends Car {
	static String brand = "BW";

	BW(int doors, String color) {
        super(doors, color);
		//System.out.println("This is a " + doors + " doors" + " " + color + " " + this.brand + " car");
	}
	
}

class Person {
	String name;
	BW c;

	Person(String name) {
		this.name = name;
		System.out.println(name + " is a rich guy");
	}

	void buyCar(BW car1) {
		this.c = car1;
		System.out.println(this.name + " bought a car ");
		//System.out.println(this.c.color);
		System.out.println("This is a " + this.c.doors + " doors" + " " + this.c.color + " " + this.c.brand + " car");
	}

}

public class homework02 {

	public static void main(String[] args) {
		Person p = new Person("Steven");
		BW car1 = new BW(4, "white");
		p.buyCar(car1);

	}

}
