package com.qianfeng.sort;


class Animal{
	String name;
	
//	public Animal() {
//		
//	}
	
	public Animal(String name) {
		this.name = name;
		System.out.println(name);		
	}
	
	
}

class Pig extends Animal{
	public Pig() {
		super("bai");
		System.out.println("zhe shi yi zhi zhu");		
	}
	
	
//	static void name() {
//		System.out.println(this.name);		
//	}
	
}



public class homework05 {
	
	public static void main(String[] args) {
		
		Pig pig = new Pig();
		
		//pig.name();
		
	}

}
