package com.qianfeng.test;

public class Demo5interface {
	//1.在jdk1.7的接口中可以写方法的实现,方法必须是default或static的
	//2.接口还是不能直接创建对象,要通过子类
	/*
	 * 接口的子类重写方法注意事项
	 * 如果一个类实现两个接口，这两个接口同时有相同的抽象方法，在类中只需要重写一次这个方法。 
	如果接口中有default修饰的方法不需要重写。 
	如果两个接口里的方法名相同都是default方法，里面的方法体不同，在类中需要重写该方法。 
	如果两个接口中方法名，参数都相同的方法，一个接口是抽象方法，另一个是default修饰有方法体。这时该类也必须重写该方法。
	 */
	public static void main(String[] args) {
		//一个类有一个接口的情况
		
//		//讲解Test6
//		Test6 test1 = new Test6();
//		test1.run();
//		test1.eat();//调用父类的defalut方法,可以通过子类的引用调用
//		//接口中static类型的方法,必须使用当前方法所在的接口名字去调用
//		inter5.bark();
		
		
		
		//一个类有两个接口的情况
		
		Test5 test = new Test5();
		test.run();
		//两个接口的同名方法,两个都是default类型的
		test.eat();
		
		//子类的静态方法可以与父类的相同,但是方法在调用的使用各自调用各自的
		inter5.bark();
		//如果两个接口中只有一个有default方法,不需要重写,可以直接使用
		test.song();

		Test5.bark();
		
		//两个接口中的同名方法,一个是default类型的(有实现),一个是抽象的
		test.play();
	}
}

interface inter5{
	public void run();
	
	default public void song() {
		System.out.println("song");
	}
	default public void eat(){
		System.out.println("default");
	}
	
	static public void bark(){
		System.out.println("static");
	}
	
	default public void play() {
		System.out.println("play");
	}
}

interface inter6{
	public void run();
	default public void eat(){
		System.out.println("default1");
	}
	
	static public void bark(){
		System.out.println("static1");
	}
	
	public void play();
}

class Test6 implements inter5{


	//
	public void run() {
		System.out.println("Test6");
		
		
	}
	
	//default只能放在接口中
		//如果当前接口中有一个default方法,不需要重写,可以直接使用
	//比如现在的eat方法
	
	//子类的静态方法可以与父类的相同,但是方法在调用的时候各自调用各自的
	static public void bark(){
		
		System.out.println("static");
	}
	
}

class Test5 implements inter5,inter6{

	//如果两个接口中有相同的抽象方法,只需要重写一次
	public void run() {
		System.out.println("run");
		
	}
	
	
	
	
	//如果两个接口中有相同的都有default实现的方法,我们必须要重写
	//在重写方法中可以同时对两个父接口的调用,也可以只调用其中一个
	 public void eat() {
		// TODO Auto-generated method stub
		inter6.super.eat();//调用inter1中的方法
		inter5.super.eat();//调用inter中的方法
		
		//再写自己的功能
		System.out.println("Test-eat");
	}

	//如果两个接口中有两个同名的方法,一个是default实现的方法,一个是抽象方法,我们必须要重写
	//在重写方法中可以同时对两个父接口的调用,也可以调用一个
	public void play() {
		inter5.super.play();
		System.out.println("");
	}


	//子类的静态方法可以与父类的相同,但是方法在调用的时候各自调用各自的
	static public void bark(){
		
		System.out.println("substatic");
	}
	
}
