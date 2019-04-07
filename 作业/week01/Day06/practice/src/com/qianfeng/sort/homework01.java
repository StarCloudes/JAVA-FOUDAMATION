package com.qianfeng.sort;

class Pet{
	String name;
	int year;
	
	public Pet(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	void eat(String pet,String food) {
		System.out.println(pet+ " likes eating" + food);
	}
	
}

class Dog extends Pet{
	
	public Dog(String name, int year) {
		super(name, year);
		System.out.println(name + " is a " + year +" years old dog");
	}

	void watchHome() {
		System.out.println(this.name+ " Dog is watching home ");
	}

}


class Cat extends Pet{
	public Cat(String name, int year) {
		super(name, year);
		System.out.println(name +" is a " + year +" years old cat");

	}

	void catchMouse() {
		System.out.println(this.name+ " Cat is catching mouse ");
	}

}


class RichWomen{
	String name;
	Dog dog1;
	Cat cat2;
	
	public void buyDogs(String name,int year) {
		System.out.println("Rich Woman bought a dog");
	    dog1 = new Dog(name,year);
	}
	
	public void buyCats(String name,int year) {
		System.out.println("Rich Woman bought a cat");
	    cat2 = new Cat(name,year);
	}
	
	public void introduePets(String pet) {
		System.out.println("She is introducing a " + pet);
	}
	
	public void holdParty() {
		System.out.println("She is holding a huge party ");
	}
}

public class homework01 {
	public static void main(String[] args) {
		RichWomen p = new RichWomen();
		p.buyDogs("Bai",2);
		p.dog1.watchHome();
		
		System.out.println("******");
		p.buyCats("Jan",0);
		
		System.out.println("******");
		Cat cat = new Cat("Cai",1);
		
		p.dog1.watchHome();
		
	}
}

