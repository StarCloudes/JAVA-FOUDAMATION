package com.qianfeng.test;
/*
 * 多态:一种事物的多种形态.    狗 ==  动物   ==  生物       花 == 植物  ==  生物     人== 高等动物  ==  动物
 * 继承是多态的前提
 * 
 *明天:
 *1继续多态
 *向上转型
 *向下转型
 *多态中成员的使用
 *instanceof的使用
 *2.Object类
 *3.内部类---待定
 */
public class Demo6 {
	public static void main(String[] args) {
		//继承
		Student student = new Student();
		student.show();
		student.run();
		
		//多态:父类的引用指向子类的对象,这个父类不一定是直接的父类
		/*
		 * 程序运行分成三个阶段:预编译,编译,运行
		 * 预编译:程序打开的时候,活儿已经干完了.(预处理命令 #define)
		 * 编译:从打开程序开始到点击左上角的三角之前---只能识别=前面的引用类型,不会识=后面的对象
		 * 运行:从点击三角开始---真正的识别对象,对象开始干活儿
		 * 
		 * 了解的内容:
		 * 实现动态的手段:动态类型,动态绑定,动态加载
		 * 动态加载:我们在编译阶段不能确定具体的对象类型,只有到了运行阶段才能确定真正的干活儿的对象.
		 */
		Person person = new Student();
		person.show();
		//person.run();//工作机制:1.首先通过Person保存的地址找到Student对象   2.Student对象再去调用run方法.
		//不能通过的原因:在编译的时候识别的是引用类型,不识别对象.所以只能识别出Person里面的方法,而不能直接
				//调用子类特有的方法.
		
		/*
		 * 总结:优点:可以提高代码的扩展性,使用之前定义好的功能,后面直接拿来使用,不用再创建新的方法.实例在Demo7
		 * 缺点:只能直接调用父类有的方法,不能直接调用子类特有的方法.
		 */
	}
}

class Person{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public Person() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void show() {
		System.out.println("Person-show");
	}
}

class Student extends Person{
	public void run() {
		System.out.println("Student-run");
	}
}
