package com.qianfeng.test;
//优点:可以提高代码的扩展性,使用之前定义好的功能,后面直接拿来使用,不用再创建新的方法.实例在Demo7
public class Demo7 {
    public static void main(String[] args) {
		Dog1 dog1 = new Dog1();
		Cat1 cat1 = new Cat1();
	    Tiger tiger = new Tiger();
		
//		feedDog(dog1);
//		feedCat(cat1);
//		feedTiger(tiger);
	    feedAnimal(dog1);
	    feedAnimal(cat1);
	    feedAnimal(tiger);
	}
    
    //喂猫,狗,动物
    public static void feedAnimal(Animal1 animal) {//animal = dog1 = new Dog1()   多态
    	animal.eat();
    }
//    public static void feedDog(Dog1 dog1) {
//    	dog1.eat();
//    }
//    public static void feedCat(Cat1 cat1) {
//    	cat1.eat();
//    }
//    public static void feedTiger(Tiger tiger) {
//    	tiger.eat();
//    }
}

class Animal1{
	String name;
	public Animal1(String name) {
		super();
		this.name = name;
	}
	public Animal1() {
	}
	public void eat(){
		System.out.println("Animal1-eat");
	}
}

class Dog1 extends Animal1{
	public void  eat() {
		System.out.println("Dog1-eat");
	}
}

class Cat1 extends Animal1{
	public void eat(){
		System.out.println("Cat1-eat");
	}
}

class Tiger extends Animal1{
	public void eat(){
		System.out.println("Tiger-eat");
	}
}
