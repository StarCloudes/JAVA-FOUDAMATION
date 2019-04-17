package com.classroom.homework23;

//3种获取Class类的方法
public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		fun3();
	}
	
	public static void fun1() {
		Person person = new Person();  //首先必须有个对象
		Class<?> class1 = person.getClass();				
	}
	
	public static void fun2() {
		Class<?> class2 = Person.class; //当前类必须是可见的，对类的依赖性太强
		System.out.println(class2);
	}
	
	public static void fun3() throws ClassNotFoundException {  //Class类它提供forName方法
		Class<?> class3 = Class.forName("com.classroom.homework23.Person");
		//System.out.println(class3);
		
	}
}
