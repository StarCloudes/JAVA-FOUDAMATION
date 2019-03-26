package com.qianfeng.test;
/*
 * 构造方法:调用的方式:类名+()
 * 作用:对对象的属性进行初始化,如果我们自己不创建构造方法,系统会调用默认的无参构造方法
 * 
 * 自己创建构造方法:
 * 分类:
 * 1.创建无参的构造方法:会将成员变量默认初始化成null/false/0
 * 2.创建有参的构造方法:会将成员变量进行初始化并赋值,赋值成你传进来的参数
 * 
 * 构造方法的基本构成:
 * 修饰词    方法名字(参数列表){
 * 		方法体
 * }
 * 注意点:1.没有返回值这一项    2.方法名必须与当前的类名同名
 * 
 * 使用构造方法的注意点:
 * 1.一旦创建了自己的构造方法,就不会再去调用系统默认的构造方法
 * 2.多个构造方法之间是重载的关系
 * 
 * this:是一种引用数据类型,本身是一个关键字,代表的是当前的对象,保存的是当前对象的地址
 * 场景:当我们想在当前类的内部拿到当前对象的引用时,可以使用this
 * 
 * this的功能总结:
* 1.用来区分成员变量和局部变量
* 2.可以在构造方法内部调用其他重载的构造方法,提高代码的复用性,简化代码
* 
* 注意点:
* //1.不能自己调用自己---死循环
* //2.不能相互调用,死循环
* //3.this充当构造方法时,必须放在第一行
*  //4.this在作为方法的时候,只能充当构造方法,不能作为其他方法
*  //5.this的使用范围就是当前类的内部
*  
*  明天:
*  代码块儿
*  封装性
*  get,set
*  继承性
*  final
*  interface
*  abstract
*  单例
 */
public class Demo8 {
	public static void main(String[] args) {
		//通过无参构造方法创建对象
		Teacher teacher = new Teacher();
		teacher.name = "凯哥";
		
		//通过有参构造方法创建对象
		Teacher teacher1 = new Teacher("有参",4);
		teacher1.name = "凯哥";
	}
}

class Teacher{
	String name;
	String name1;
	int age;
	//无参构造方法
	public Teacher() {
		//this();//不能自己调用自己---死循环
		System.out.println("无参构造方法");
	}
	
	//有参的构造方法
    //参数一般写成与要被赋值的成员变量同名
	//当成员变量与局部变量同名时,方法内部默认识别的是局部变量---这里依据的是就近原则(在内存中离方法的远近判断)
	//解决方法:使用this调用成员变量,加以区分
	public Teacher(String name,int age) {
		this(name);//this充当构造方法时,必须放在第一行
		//this.name = name;
		this.age = age;
		//System.out.println("有参构造方法");
	}
	
	public Teacher(String name) {
		//this(name, 4);//不能相互调用,死循环
		this.name = name;
		System.out.println("有参构造方法");
	}
	
}
