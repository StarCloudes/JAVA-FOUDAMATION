package com.Test;
//���һ����(Point)��, ʵ�����й���: �����������, �õ�һ���µĵ�, �µĵ��x��y������ԭ���������x��y�����, 
//����: Point { x = 10, y = 20 }, Point { x = 15, y = -5 } �õ��� Point { x = 25,y = 15}
public class Test4 {
	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(15, -5);
		System.out.println(p1.getNewPoint(p2));
	}
}
class Point {
	private int x;
	private int y;
	
	public Point getNewPoint(Point p) {
		return new Point(this.x + p.getX(), this.y + p.getY());
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point() {}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
