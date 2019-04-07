package com.qianfeng.test;
/*
 * 匿名内部类(对象):定义在一个类方法中的匿名子类对象,属于局部内部类
 * 匿名子类对象:
 * 匿名内部类对象:
 * 
 * 创建匿名内部类对象注意点:1.匿名内部类对象必须有父类或者父接口
 * 
     匿名内部类对象的作用:
 * 1.当只用到当前子类的一个实例对象的时候,定义好马上使用
 * 2.当不好起名字的时候
 * 3.可以更好的定义运行时的回调(知道即可)
 * 
 * 内部类的作用:
 * 1.间接实现了多继承
 * 2.方便定义
 * 3.只有外部类可以访问创建的内部类的属性和方法,包括私有方法
 * 4.同一个包中其他的类不可见,有了很好的封装性
 * 
 * 
 * 明天知识:
 * 1.异常
 * 2.模板设计模式
 * 3.包装类
 * 4.字符串
 */
public class Demo8 {
	public static void main(String[] args) {
		//研究匿名子类对象
		Animal animal = new Animal();
		//animal.eat();
		//new Animal().eat();//匿名对象
		//创建匿名子类对象
		//第一种方式:使用已有的子类创建匿名子类对象
		//使用场景:已经创建好的子类可以多次使用,适用于相同的功能被多次调用
		//new Dog().eat();
		//第二种方式:这里也是Animal的匿名子类对象
		//直接创建了没有名字的Animal的匿名子类对象
		//构成: new +  父类的名字/接口的名字 + () + {写当前子类的成员} + ;
		//使用场景:只能使用一次,使用完会被当做垃圾回收,适用于每次都使用不能的功能
		new Animal() {
			int age;
			@Override
			public void eat() {
				System.out.println("111eat");		    
			}
			
			public void show() {
				System.out.println("show");
			}
		}.show();
		//给匿名子类对象起一个名字
		Animal animal2 = new Animal() {
			int age;
			@Override
			public void eat() {
			    System.out.println("当前的eat");
			}
			
			public void show() {
				System.out.println("show");
			}
		};
		animal2.eat();
		
		//匿名内部类
		Test1 test1 = new Test1();
		test1.canshuTest();
		test1.canshuTest1();
		
		Animal animal3 = test1.fanhuizhiTest();
		Animal animal4 = test1.fanhuizhiTest1();
		System.out.println(animal3+"         "+animal4);
		
	}
}

//研究匿名子类对象
class Animal{
	public void eat() {
		System.out.println("父-eat");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("子-eat");
	}
}

//研究匿名内部类
class Test1{
	public void show() {
		new Animal() {//匿名内部类
			@Override
			public void eat() {
				System.out.println("haha");
			}
		}.eat();
	}
	//使用匿名对象作为参数
	public void canshuTest() {
		System.out.println(new Animal());
	}
	public void canshuTest1() {
		System.out.println(
				
	    new Animal() {
			@Override
			public void eat() {
				System.out.println("canshuTest1-eat");
			}
			public int song() {
				return 5;
			}
			@Override
			public String toString() {
				return "toString";
			}
		}
				);
		
	}
	//使用匿名对象作为返回值
	public Animal fanhuizhiTest() {
		return new Animal();
	}
	//使用匿名内部类对象作为返回值
	public Animal fanhuizhiTest1() {
		return new Animal() {
			public int show() {
				return 10;
			}
		};
	}
	
	//接口的匿名内部类---作业
}




