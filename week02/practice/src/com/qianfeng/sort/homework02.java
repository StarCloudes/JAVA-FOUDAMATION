package com.qianfeng.sort;

class Car{
	int doors;
	String color;
	
}

class BW extends Car{
	static String brand = "BW";
	
    BW(int doors, String color) {
		System.out.println("This is a " + doors+ " doors" + " "+ color+ " "+ this.brand +" car");
	}
}

class Person{
	String name;
	BW car1;
	
	Person(String name) {
		this.name = name;
		System.out.println(name + " is a rich guy");
	}
	
	void buyCar(int doors, String color) {
		System.out.println(this.name + " bought a car ");
		car1 = new BW(doors,color);
	}
	
}

public class homework02 {
	
	public static void main(String[] args) {
		Person p = new Person("Steven");
		//p.buyCar(4,"white");
		
		BW car = new BW(4,"white");
		
	
	}
	
	

}
