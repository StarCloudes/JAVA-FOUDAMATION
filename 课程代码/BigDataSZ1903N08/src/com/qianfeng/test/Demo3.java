package com.qianfeng.test;
/*
 * 代码块儿:
 * 静态代码块儿:随着类的加载而加载,在整个程序执行过程中只执行一次,执行顺序优先于main
 * 构成:static+{}
 * 作用:对类进行初始化
 * 构造代码块儿:随着对象的加载而加载,每次创建对象的时候都会执行一次,执行顺序优先于构造方法.
 * 构成:{}
 * 作用:对对象进行初始化
 */
public class Demo3 {
	static {System.out.print("a");}
	public static void main(String[] args) {
		System.out.print("c");
		Pig pig = new Pig("佩奇");
		pig.show();
		Pig pig1 = new Pig("佩奇");
	}
	static {System.out.print("b");}
}
class Pig{
	String name;
	public  Pig() {
	    System.out.print("d");	
	}
	public  Pig(String name) {
		this.name = name;
		System.out.print("e");	
	}
	public void show() {
		System.out.print("f");
	}
	//静态代码块儿
	static {System.out.print("g");}
	//构造代码块儿
	{System.out.print("k");}
}
