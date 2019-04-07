package com.qianfeng.test;

public class Demo5 {
	public static void main(String[] args) {
		Pig pig = new Pig();
		pig.name = "荷兰猪";
		
		//匿名对象:没有名字的对象---创建出来就是垃圾,因为没有引用指向他
		//作用:节省代码,节省内存
		//使用的场景:充当参数
		//注意点:使用匿名对象充当参数适合于:不在方法的外部给作为参数的对象赋任何属性值的前提下.
		new Pig().name = "家猪";
		new Pig().age = 20;
		
		//创建一个猪对象
//		Pig pig1 = new Pig();
//		pig1.name = "小猪";
		feedPig(new Pig());
	}
	
	public static void feedPig(Pig pig) {
		pig.eat();
	}
}

class Pig{
	String name;
	int age;
	public  void eat() {
		System.out.println(name+"吃");
	}
}
