package com.qianfeng.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 2.通过字节码文件对象获取对应的实例对象
public class Demo3 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//利用普通方法求对象
		Person person = new Person();
		
		//利用反射求对象
		//1.创建字节码文件对象
		Class<?> class1 = Class.forName("com.qianfeng.test.Person");
		//2.利用无参构造方法创建对象
		fun1(class1);
		//3.利用有参构造方法创建对象
		fun2(class1);
	}
	//2.利用无参构造方法创建对象
	public static void fun1(Class<?> class1) throws InstantiationException, IllegalAccessException {
		//创建实例对象
		//这里相当于在newInstance内部调用了无参的构造方法
		Object object = class1.newInstance();
		Person person = (Person)object;
		person.setName("bing");
		String myname = person.getName();
		System.out.println(person.getName());
	}
	//3.利用有参构造方法创建对象
	public static void fun2(Class<?> class1) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		//得到有参构造方法
		//得到的是:Person(String name, int age)
	   	 //这里的参数是实际的构造方法的参数的字节码文件
	   	 //注意点:简单数据类型也有字节码文件  ,获取字节码文件的方式都可以通过.class实现
		 Class<?> class2 = Class.forName("java.lang.String");
		 Constructor<?> constructor =  class1.getConstructor(class2,int.class);
		 //调用构造方法创建对象
		 Person person = (Person) constructor.newInstance("bing",20);
		 System.out.println(person);
	}
}
