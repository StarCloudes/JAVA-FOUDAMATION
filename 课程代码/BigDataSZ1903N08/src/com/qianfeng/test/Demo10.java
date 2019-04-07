package com.qianfeng.test;
/*
 * 抽象:abstract:是一个关键字
 * 声明:不写函数体的函数,可以叫声明
 * 抽象方法和抽象类:
 * 
 	可以修饰方法----抽象方法
 * 修饰类----抽象类:在继承中,提取父类方法的时候,每个子类都有自己具体的方法实现,父类不能决定他们各自的实现方法
 * 所以父类干脆就不管了,在父类中只写方法的声明(负责制定一个规则),将方法的实现交给子类.在类中只有方法声明的方法叫抽象方法,拥有抽象
 * 方法的类叫抽象类
 * 
 抽象类的功能:1.可以节省代码   2.可以指定一批规则
 * 
 * 注意点:
 * 1.抽象类不一定有抽象方法,但是有抽象方法的一定是抽象类.
 * 2.继承了抽象类的子类一定要实现抽象方法,如果不实现就只能将自己也变成抽象的.
 * 3.抽象类不能直接创建对象,必须通过子类实现,所以抽象类一定有子类
 * 
 * 比较普通类与抽象类:
 * 1.普通类可以直接创建对象
 * 2.抽象类可以有抽象方法
 * 
 * 
  * 不能与abstract同时存在的关键字
 * 1.final:被final修饰的类不能有子类,方法不能重写,但是abstract必须有子类,必须重写
 * 2.static:修饰的方法可以通过类名调用,abstract必须通过子类实现
 * 3.private:修饰的方法不能重写,abstract必须重写
 * 
 * 
 * 实例:求圆与矩形的面积
 * 
 * 明天:
 * 1.单例
 * 2.接口
 * 3.多态
 */
public class Demo10 {
	public static void main(String[] args) {
		//抽象方法不能直接创建对象,可以通过子类实现功能
		//Person person = new Person() ;
	}
}

//拥有抽象方法的类一定是抽象类
abstract class Person{
	String name;
	public  void show() {
		System.out.println("show");
	}
	public abstract void run();//抽象方法
}

 class Student extends Person{
	public void show() {
		System.out.println("Zishow");
	}
	
	//当子类继承了抽象类时,报错的两种处理方法:
	//1.将自己变成抽象的
	//2.将父类的抽象方法实现---最终采用的第二种
	public void run() {
		
		
	}
}
