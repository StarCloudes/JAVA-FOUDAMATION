package com.exam03.homework20;

//设计一个点(Point)类, 实现下列功能: 让两个点相加, 得到一个新的点, 新的点的x和y坐标是原来两个点的x和y坐标和, 例如:
//Point { x = 10, y = 20 }, Point { x = 15, y = -5 } 得到点 Point { x = 25,y = 15}
public class Demo4 {
	public static void main(String[] args) {
		Point a = new Point(10,20);
		Point b = new Point(15,-5);
		Point c = Point.add(a, b);
		System.out.println(c);
	}

}

class Point{
	int x;
	int y;
	
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Point add(Point a, Point b) {
		Point c = new Point();
		c.x = a.x + b.x;
		c.y = a.y + b.y;
		return c;
	}
	@Override
	public String toString() {
		return "Point {x=" + x + ", y=" + y + "}";
	}
	
}
