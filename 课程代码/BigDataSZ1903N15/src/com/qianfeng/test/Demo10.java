package com.qianfeng.test;
/*
 * 在接口上使用泛型
     我们主要研究的是实现接口的子类上的泛型是如何使用的
 */
public class Demo10 {
	public static void main(String[] args) {
		//1.子类与接口上的泛型保持一致
		Dog<Integer> dog = new Dog<>();
		dog.show(34);
		
		//2.接口上使用泛型,子类上不用泛型
		Cat cat = new Cat();
		cat.show("haha");
	}
}

interface Inter<E>{
	public void show(E e);
}

//1.子类与接口上的泛型保持一致
/*
 * 类上的泛型确定了,接口上的泛型就确定了,方法上的泛型就确定了
 */
class Dog<E> implements Inter<E>{
	public void show(E e) {
	}
}

//2.接口上使用泛型,子类上不用泛型
/*在实现的接口位置必须指定一个具体的泛型
 * 
 * 方法使用泛型的情况:
 * 1.如果是重写的方法,泛型与接口一致
 * 2.如果是子类自己的方法,可以与接口一致,也可以有自己的泛型
 */
class Cat implements Inter<String>{
	public void show(String e) {
	}
}
