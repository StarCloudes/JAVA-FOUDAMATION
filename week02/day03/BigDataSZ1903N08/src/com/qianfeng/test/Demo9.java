package com.qianfeng.test;

public class Demo9 {
	public static void main(String[] args) {
		/*
		 * 例子:求圆的面积
		 */
		Circle circle = new Circle(2);
		double area = circle.getArea();
		System.out.println(area);
		
		circle.test(1);
	}
}

class Circle{
	private double radius;
	private final double PI = 3.14;//符号常量
	
	public double getArea() {
		return PI*radius*radius;
	}
	
	public Circle(double radius) {
		///super();
		this.radius = radius;
	}

	public Circle() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	//符号常量应用
	final int HAPPY = 1;
	final int UNHAPPY = 2;
	public void test(int a) {
		if (a == HAPPY) {
			System.out.println("Happy");
		}else if (a == UNHAPPY) {
			System.out.println("Unhappy");
		}
	}
}
