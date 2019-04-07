package com.qianfeng.test;

/*
 * 内部类:定义在A类里面的B类就是内部类,内部类的地位与A类的成员变量,成员方法平等,内部类也可以看做是A类的成员,
 * 		   成员之间可以相互调用
 */
public class Demo4 {
    public static void main(String[] args) {
    	//创建内部类对象的两种方式
    	Outer outer = new Outer();
		//1.借用外部类的方法
    	outer.show();
    	//2.直接创建对象    
    	//引用:外部类.内部类
    	//构成:外部类对象的引用.new 内部类的构造方法
//    	Outer.Inner inner = outer.new Inner();
//    	inner.run();
//    	
	}
}

class Outer{
	String name;
	class Inner{//内部类
		int age;
		public void run() {
			System.out.println("Inner类-run");
		}
	}
	
	public void show() {
		//创建Inner的对象
		Inner inner = new Inner();
		inner.run();
		System.out.println("Outer类-show");
	}
}

//说明功能
//我们可以通过内部类让java间接实现多继承
class A{
	public void show() {
		
	}
}
class B{
	public void song() {
		
	}
}

class X extends A{
	class Y extends B{
		
	}
}

