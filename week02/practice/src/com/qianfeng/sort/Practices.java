package com.qianfeng.sort;

class Point{
	private double x;
	private double y;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double countDistance(double x1, double y1,double x2, double y2) {
		double distance = Math.sqrt((x1-x2)*(x1-x2)+ (y1-y2)*(y1-y2));
		return distance;
	}
}

class Circle{
	int banjin;
	final double Pai = 3.1415926;
	
	public Circle(int r) {
		this.banjin = r;
	}
	
	public double mianji(Circle c) {
		double mianji = Pai * c.banjin * c.banjin;
		return mianji;
	}
	
}


public class Practices {
	public static void main(String[] args) {
		
		Circle c = new Circle(2);
		double mianji = c.mianji(c);
		System.out.println(mianji);
		
		Point point1 = new Point();
		point1.setX(0);
		point1.setY(0);
		double x1= point1.getX();
		double y1= point1.getY();
		
		Point point2 = new Point();
		point2.setX(1);
		point2.setY(1);
		double x2= point2.getX();
		double y2= point2.getY();
		
		double distance = point1.countDistance(x1,y1,x2,y2);
		//System.out.println("两点之间的距离：" + distance);
		
	}
	


}
