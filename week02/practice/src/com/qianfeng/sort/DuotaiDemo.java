package com.qianfeng.sort;

abstract class Animal2 {
	abstract void eat();
}

class Dog2 extends Animal2 {
	public void eat() {
		System.out.println("啃骨头");
	}

	public void lookHome() {
		System.out.println("看家");
	}
}

class Cat2 extends Animal2 {
	public void eat() {
		System.out.println("吃鱼");
	}

	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class DuotaiDemo {
	public static void main(String[] args) {

		Animal2 a = new Cat2();
		Animal2 b = new Dog2();
		
		method(a);
		method(b);

		Cat2 c = (Cat2) a;
		c.eat();
		c.catchMouse();

	}

	public static void method(Animal2 a) {
		a.eat();
	}
}