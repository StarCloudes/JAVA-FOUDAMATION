package com.classroom.homework23;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> class1 = Class.forName("com.classroom.homework23.Person");
		
		fun2(class1);
	}
	
	//无参构造方法创建对象
	public static void fun1(Class<?> class1) throws InstantiationException, IllegalAccessException {
		Object object = class1.newInstance(); //调用无参构造方法
		Person person = (Person)object;
		person.setName("chen");
		System.out.println(person.getName());
	}
	
	//有参数构造方法创建对象
	public static void fun2(Class<?> class2) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Constructor<?> constructor = class2.getConstructor(String.class,int.class);
		//得到Person（String name，int age）构造方法
		Person person = (Person)constructor.newInstance("bing",20);
		System.out.println(person);
	}
}
