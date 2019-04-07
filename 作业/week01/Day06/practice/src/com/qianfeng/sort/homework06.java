package com.qianfeng.sort;

//求圆与矩形的面积

public class homework06 {
	
	public static void main(String[] args) {
		Circles c = new Circles(2);
		double area = c.getArea();
		System.out.println(area);
		
		Rectangle r = new Rectangle(2,4);
		double area2 = r.getArea();
		System.out.println(area2);
	}
	
}

abstract class Shape{
	abstract double getArea() ;
}

class Circles extends Shape{
	private int radius;
	private  final double PI = 3.14;
	
	public Circles(int r) {
		this.radius = r;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}
	
}

class Rectangle extends Shape{
	private int width;
	private int length;
	
	public Rectangle(int w,int l) {
		this.width = w;
		this.length = l;
		
	}
	
	public double getArea() {
		return width * length;
	}
	
	
	
}

