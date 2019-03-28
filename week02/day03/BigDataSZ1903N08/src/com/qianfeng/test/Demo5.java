package com.qianfeng.test;

public class Demo5 {
	public static void main(String[] args) {
		/*
		 * 计算两点之间的距离
		 * 使用静态方法和非静态方法求解
		 */
		//Math.sqrt(5);
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		
		double distance1 = Point.getDistance(p1, p2);
		System.out.println(distance1);
		
		double distance2 = p1.getDistance(p2);
		System.out.println(distance2);
	}
}

class Point{
	double x,y;
	//使用静态方法计算距离
	public static double getDistance(Point p1,Point p2) {
		double temp = (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
		return Math.sqrt(temp);
	}
	//非静态方法
	public double getDistance(Point p) {
		double temp = (this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y);
		return Math.sqrt(temp);
	}
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}


