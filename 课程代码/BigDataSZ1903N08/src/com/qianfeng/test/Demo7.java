package com.qianfeng.test;
/*
* 在继承中使用构造方法
* 
 * * 
* 1.当一个子类中只有一个带参数的构造方法,只能使用带参数的,不能使用无参的.如果想使用,必须手动建立无参的构造方法
* 2.当父类中只有带参数的构造方法,子类的构造方法中就必须在第一行手动调用父类带参数的构造方法(super(参数))
* 3.当我们创建构造方法的时候,如果自己不写super(),系统会自动调用
* 原因:父类中也有属性要进行初始化,而对象的属性必须由自己的构造方法进行初始化,所以必须调用super(),所以每个构造方法中都默认有一个super()
* 
* 为什么要将super放在方法的第一行?
* 答:在子类的构造方法中有可能用到父类的属性,而属性在使用之前必须先进行初始化,否则无法使用.
* 
* 总之:在继承体系中,作为父类最好的办法就是将无参构造方法和有参构造方法都写了.
* 
* 注意:每次创建类时必须有的内容:1属性  2.get,set   3.有参无参构造方法  4.toString方法
* */
public class Demo7 {
	public static void main(String[] args) {
		Dog dog = new Dog();
	}
}
class Animal{
	String name;
//	public Animal() {
//		// TODO Auto-generated constructor stub
//	}
	public Animal(String name) {
		this.name = name;
	}
}
class Dog extends Animal{
	public Dog() {
		//super();//默认调用父类无参的构造方法,如果不写,会调用系统默认的父类构造方法
		super("bing");//必须放在第一行
		name = "ik";
	}
}
