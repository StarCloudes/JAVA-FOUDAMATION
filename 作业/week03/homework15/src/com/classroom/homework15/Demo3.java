package com.classroom.homework15;

import java.util.ArrayList;

public class Demo3 {
	public static void main(String[] args) {
		Pig<String> pig = new Pig();
		pig.show("haha");
	}

}

class Pig<F> {

	// 1.
	public void show(F f) {
		System.out.println(f);
	}

	// 2.
	public <E> void run(E e) {
		ArrayList<E> list = new ArrayList<E>();
	}

	// 3.
	public static <W> void eat(W w) {

	}
}

interface Inter<D> {
	public void show(D d);
}

//1.
class Dog<D> implements Inter<D> {

	public void show(D d) {

	}
}

//2.
class Cat implements Inter <String> {
	
	public void show(String d) {

	}
}
