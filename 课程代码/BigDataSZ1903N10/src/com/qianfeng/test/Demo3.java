package com.qianfeng.test;
/*
 * instanceof:这是一个运算符
 * 构成:  对象   instanceof  类或类的子类
 * 原理说明:确定当前的对象是否是后面的类或者子类的对象,是返回true,不是false
 * 作用:进行容错处理,增加用户体验
 */
public class Demo3 {
    public static void main(String[] args) {
    	Student1 student1 = new Student1();
		Teacher1 teacher1 = new Teacher1();
		//meeting(student1);
		meeting(teacher1);
	}
    
    //跟老师或者学生开会,参数写成Person1即可
    public static void meeting(Person1 person1) {//person1 = student1  多态
    	//如果person1对应的对象不是Student1或者Student1的子类的对象,这里返回false
    	if (person1 instanceof Student1) {
    		//向下转型
        	Student1 student1 = (Student1)person1;
        	student1.eat();
		}else if (person1 instanceof Teacher1) {
			
		}else {
			System.out.println("当前的对象不是Student1类或者子类的对象");
			System.out.println("当前的对象也不是Teacher1类或者子类的对象");
		}
    	
    	
    	//instanceof的前后必须有继承关系
//    	Dog dog = new Dog();
//    	if (dog instanceof Student1) {
//			System.out.println("");
//		}
    }
}

class Dog{
	
}
class Person1{
	String name;

	public Person1(String name) {
		super();
		this.name = name;
	}

	public Person1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println("Person1-show");
	}
}

class Teacher1 extends Person1{
	public void play() {
		System.out.println("Teacher1-play");
	}
}

class Student1 extends Person1{
	public  void eat() {
		System.out.println("Student-eat");
	}
}