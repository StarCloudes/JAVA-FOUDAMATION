package com.qianfeng.test;
/*
 * 设计模式:前人总结出来的对一些常见问题的解决方案,后人直接拿来使用.
 * 常用的设计模式:单例,工厂,代理,适配器,装饰,模板,观察者等,一共有23种
 * 单例:一个类只允许有一个对象,建立一个全局的访问点,提供出去供大家使用.
 * 
  * 分析:
 * 1.我们肯定要建立一个单例类来描述
 * 2.只允许有一个对象
 * 3.全局的访问点:说的就是当前的s----通过static实现的
 * 4.提供出去
 * 5.给大家使用
 * 
 * 
 * 
 * 作用:
 * 1.传值
 * 2.作为全局的访问点.
 * 
 *使用单例传值的好处:
 * * 好处:可以让两个对象在完全没有关系的前提下,实现值的传递,降低了耦合性,提高了内聚性
 * 
 * 耦合性,内聚性在微观上说:描述的是类与类之间的关系
 * 好处:我们应该尽量提高内聚性,减少耦合性,可以提高程序的健壮性,增加代码的可移植性,方便实现模块儿化编程
 * 
 * 如何做到低耦合高内聚?
 * 在处理类与类关系的时候,让类之间的关系越紧密耦合性越高,内聚性越低.反之,关系越松散耦合性越低,内聚性越高.
 */

//单例分类:
//饿汉式:
class SingleInstance{
	//在单例类的内部创建一个当前类的静态的私有化的对象
	private static final SingleInstance singleInstance = new SingleInstance();
	
	//创建构造方法,并私有化
	private SingleInstance() {
		
	}
	
	//通过公共的静态的方法将singleInstance对象提供出去
	public static SingleInstance getInstance() {
		return singleInstance;
	}
}
//懒汉式:
class SingleInstance1{
	//3.在单例类的内部创建一个当前类的静态的私有化的对象
	//懒汉式不能使用final
	private static  SingleInstance1 singleInstance = null;
	
	//1.创建构造方法,并私有化
	private SingleInstance1() {
		
	}
	
	//3.通过公共的静态的方法将singleInstance对象提供出去
	public static SingleInstance1 getInstance1() {
		//为了保证对象的唯一性
		if (singleInstance == null) {
			singleInstance = new SingleInstance1();
		}
		
		return singleInstance;
	}
	
	//功能区
	//注意:功能区中的属性和方法一般都写成非静态的
	int num;
	
}
public class Demo3 {
	public static void main(String[] args) {
//		SingleInstance singleInstance1 = new SingleInstance();
//		SingleInstance singleInstance2 = new SingleInstance();
//		System.out.println(singleInstance1 == singleInstance2);//false
		
		SingleInstance singleInstance1 = SingleInstance.getInstance();
		SingleInstance singleInstance2 = SingleInstance.getInstance();
		System.out.println(singleInstance1 == singleInstance2);//true
		
		//传值:
		//实例:有一个A类和一个B类,A类中有一个变量num1,B类中有一个变量num2
		//创建A类的对象a,给变量赋值num1=4 ,创建B类的对象b,要实现的功能:将num1的值传给num2
		//1.直接赋值:不建议使用.
		A a = new A();
//		a.setNum1(4);
		B b = new B();
//		b.num2 = a.num1;
		//2.传参
		b.bText(a);
		//3.单例传值
		a.singleA();
		b.singleB();
	}
}

class A{
	private int num1 = 4;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	//用于单例
	public void singleA(){
		SingleInstance1 singleInstance1 = SingleInstance1.getInstance1();
		singleInstance1.num = num1;
	}

}

class B{
	private int num2;
	
	public void bText(A a) {
		num2 = a.getNum1();
	}
	
	//用于单例
	public void singleB(){
		SingleInstance1 singleInstance1 = SingleInstance1.getInstance1();
		num2 = singleInstance1.num;
	}
}
