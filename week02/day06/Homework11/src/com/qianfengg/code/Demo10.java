package com.qianfengg.code;

import java.util.*;

class IllegalNumException extends Exception {
	public IllegalNumException() {
		super();
	}

	public IllegalNumException(String message) {
		super(message);
	}
}

interface Inter {
	public abstract double yuan(double radius) throws IllegalNumException;

	public abstract double ju(double length, double width) throws IllegalNumException;
}

class Hh implements Inter {
	Hh() {
	};

	public double yuan(double radius) throws IllegalNumException {
		if (radius < 0)
			throw new IllegalNumException("你输入的半径不合法");
		return 3.14 * radius * radius;
	}

	public double ju(double length, double width) throws IllegalNumException {
		if (length < 0)
			throw new IllegalNumException("你输入的长不合法");
		if (width < 0)
			throw new IllegalNumException("你输入的宽不合法");
		return length * width;
	}
}

class Demo10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入圆的半径");
		double r = sc.nextDouble();
		System.out.println("请输入矩形的长");
		double a = sc.nextDouble();
		System.out.println("请输入矩形的宽");
		double b = sc.nextDouble();
		Hh mianji = new Hh();
		try {

			System.out.print("圆的面积为" + mianji.yuan(r));
		} catch (IllegalNumException e) {
			System.out.println(e.getMessage());
		}

		try {

			System.out.print("矩形的面积为" + mianji.ju(a, b));
		} catch (IllegalNumException e) {
			System.out.println(e.getMessage());
		}

	}
}
