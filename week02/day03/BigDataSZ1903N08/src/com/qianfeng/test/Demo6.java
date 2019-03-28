package com.qianfeng.test;
/*
 * 继承:有两个类A类与B类,当他们之间产生父子关系的时候,我们称为继承
 */
public class Demo6 {
	public static void main(String[] args) {
		Iphone iphone = new Iphone();
		iphone.fangShui();//Iphone自己的方法
		//对象调用方法的原理:首先会在自己的内部找这个方法,找到了直接使用,找不到会继续去父类中找,同理,找到了使用,停止查找,
		//找不到继续向上找,一直找得到Object类,如果还没有找到,就认为没有这个方法
		
		//当父类与子类出现完全相同的方法的时候,我们成为重写
		//重写的时候,子类的同名方法会把父类的方法覆盖
		//作用:在实现方法原来功能的基础上实现一些自己特有的功能
		iphone.callPhone();
		
		/*
		 * this:是一种引用类型,代表当前对象,保存的是当前对象的地址
		 * super:代表的是当前对象的父类,可以调用父类的成员.但是他不是引用数据类型.
		 */
	}
}
//如果一个类的后面没有加extends,默认父类是Object
class Phone extends Object{
	String color;
	String model;
	public void callPhone() {
		System.out.println("打电话");
	}
	
	public void test() {
		System.out.println("test");
	}
}

//子类   extends  父类
class Iphone extends Phone{
//	String color;
//	String model;
	
	String gui;
	public void callPhone() {
		//System.out.println("打电话");
		super.callPhone();//通过super调用父类的同名方法,而且super只能调用父类的方法
		//this.callPhone();//有限调用自己的方法,死循环
		//this.test();//如果不是同名的方法,可以使用this调用
		//自己的功能
		System.out.println("自己的功能");
	}
//	
	public void fangShui() {
		System.out.println("防水");
	}
}

class HuaWei extends Phone{
//	String color;
//	String model;
//	public void callPhone() {
//		System.out.println("打电话");
//	}
	
	public void niu() {
		System.out.println("牛");
	}
}
