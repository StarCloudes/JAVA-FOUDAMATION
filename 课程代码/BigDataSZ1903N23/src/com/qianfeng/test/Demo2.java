package com.qianfeng.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 反射:动态获取类的字节码文件,并对其成员进行抽象
 * 整体的含义:就是想通过字节码文件直接创建对象.
 * 
 * 过程:1.获取字节码文件对象     2.通过字节码文件对象获取对应的实例对象  3.给属性赋值(通过从属性中提取出来的类--Field)
 * 4.调用方法(通过从方法中提取出来的类--Method)
 * 
 * 先讲解获取字节码文件对象
//1.通过Object提供的getClass()方法
 * 首先必须要有一个对象    XXX
//2.通过每种数据类型都有的一个class属性
 * 在使用的位置必须当前的类是可见的,因为这里要显示的使用这个类名,对类的依赖性太强,使用不方便    XXX
//3.Class类提供的一个静态方法forName(字符串)   字符串:包名+类名
 * 我们只需要提供一个当前类的字符串形式即可
 */
public class Demo2 {
	public static void main(String[] args) throws ClassNotFoundException {
		//1.通过Object提供的getClass()方法
		fun1();
		//2.通过每种数据类型都有的一个class属性
		fun2();
		//3.Class类提供的一个静态方法forName(字符串)   字符串:包名+类名
		fun3();
	}
	//1.通过Object提供的getClass()方法
	public static void fun1() {
		Person person = new Person();
		Class<?> class1 = person.getClass();
		Person person1 = new Person();
		Class<?> class2 = person1.getClass();
		System.out.println(class1 == class2);//true,说明一个类只有一个唯一的字节码文件
	}
	//2.通过每种数据类型都有的一个class属性
	public static void fun2() {
		Class<?> class1 = Person.class;
		System.out.println(class1);
	}
	//3.Class类提供的一个静态方法forName(字符串)   字符串:包名+类名
	public static void fun3() throws ClassNotFoundException {
		//可以通过一个字符串直接得到一个字节码文件对象
		Class<?> class1 = Class.forName("com.qianfeng.test.Person");// 字符串:包名+类名
	}
	
	//解释为什么使用反射
	//因为可以脱离开具体的类,使用字符串直接得到字节码文件,这样我们就可以将当前的代码封装起来,做成框架,方便功能实现
	public static void test() throws IOException, ClassNotFoundException {
		FileReader reader1 = new FileReader("D:\\workspace\\BigDataSZ1903N23\\test2.txt");
		FileReader reader2 = new FileReader("D:\\workspace\\BigDataSZ1903N23\\test1.txt");
		
		FileReader[] fileReaders = new FileReader[] {reader1,reader2};
		
		//读
		String data = "";
		for (FileReader fileReader : fileReaders) {
			int num = 0;
			while ((num = fileReader.read()) != -1) {
				data+=(char)num;
			}
		}
		Class class1 = Class.forName(data);
	}
}
