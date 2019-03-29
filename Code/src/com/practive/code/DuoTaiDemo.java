package com.practive.code;

abstract class Animal {
	abstract void eat();
}

class Dog extends Animal {
	void eat() {
		System.out.println("啃骨头");
	}

	void lookHome() {
		System.out.println("看家");
	}
}

class Cat extends Animal {
	void eat() {
		System.out.println("吃鱼");
	}

	void catchMouse() {
		System.out.println("抓老鼠");
		System.out.println();
	}
 
}

class DuoTaiDemo {
	public static void main(String[] args) {
		// 自动类型提升，猫对象提升到了动物类型。但是特有功能无法访问，作用就是限制对特有功能的访问。
		// 专业讲：向上转型，将子类型隐藏。就不能使用子类的特有方法了。
		Animal a = new Cat();
		a.eat();
		// a.catchMouse();//报错

		// 如果还想用具体动物猫的特有功能。
		// 你可以将该对象进行向下转型。
		Cat c = (Cat) a; // 向下转型的目的是为了能够使用子类中的特有方法。
		c.eat();
		c.catchMouse();	
		

		// 注意：对于转型，自始至终都是子类对象在做类型的变化。
		// Animal a = new Dog();
		// Cat c = (Cat)a;//但是类型不能随意转换，否则可能会报出ClassCastException的异常
	}

	public static void method(Animal a) {
		a.eat();
	}
}
