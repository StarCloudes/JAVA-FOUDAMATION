package com.qianfeng.test;
/*
 * 明天内容:
 * 1.Object---基础
 * 2.内部类---了解
 * 3.异常---基础
 */
public class Demo4 {
	public static void main(String[] args) {
		//继承
		Zi zi = new Zi();
		System.out.println(zi.age);//8,继承中子类与父类出现同名的属性,父类的会被覆盖掉
		
		//多态
		Fu fu = new Zi();
		/*
		 * 当父类与子类有同名属性或方法时
		 * 成员变量:编译的时候能不能访问看父类,运行的时候也看父类
		 * 成员方法:编译的时候能不能访问看父类,运行的时候也看子类
		 * 静态成员方法:编译运行都看父类
		 */
		System.out.println(fu.age);//4
		Fu.show();//打印的父类的方法
		Zi.show();//打印的子类的方法
	}
}

class Fu{
	int age = 4;
	public void run() {
		System.out.println("Fu-run");
	}
	public static  void show() {
		System.out.println("Fu-show");
	}
}

class Zi extends Fu{
	int age = 8;
	public  void song() {
		System.out.println("Zi-song");
	}
	public static  void show() {
		System.out.println("Zi-show");
	}
}