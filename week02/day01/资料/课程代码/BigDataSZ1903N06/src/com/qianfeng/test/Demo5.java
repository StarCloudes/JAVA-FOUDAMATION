package com.qianfeng.test;
/*
 * 面向对象的三要素----最好都写英文
 * 名字:遵守大驼峰原则,所有单词的首字母大写
 * 属性:成员变量:遵守小驼峰原则
 * 行为:成员方法,遵守小驼峰原则
 * 
 * 举例:
 * 类名:人:(Person)
 * 属性:身高:height   体重:weight   年龄:age    姓名:name
 * 行为:吃饭 eat   打电话  callPhone(String tel)
 */

//创建类:类的关键字是class
class Person{
	//属性
	double height;
	double weight;
	int age;
//	char[] name;   
	String name; //String是字符串类,他的对象就表示字符串,表示形式就是""   name = "bingbing"
	//行为
	//吃饭
	public void eat() {
		System.out.println(name+"在吃饭");//在方法里可以直接使用全局变量
	}
	//打电话
	public void callPhone(String tel) {
		System.out.println(name+"在拨号:"+tel);
	}
}
public class Demo5 {
	public static void main(String[] args) {
		//创建对象
		int[] arr = new int[3];
		//创建Person类的一个对象,构成;new + 类名 +()
		//new:1.开辟一块儿内存空间    2.将地址返回
		//每创建一个类就相当于创建了一个新的数据类型
		//Person+()其实是一个整体,是一个空参的方法.作用:1.告诉别人我这里创建的是一个Person类型的对象  
		//2.给当前对象的属性赋默认值,如果是整型:就是0   如果是引用数据类型:就是null
		Person p  = new Person();
		
		//赋值的过程.通过.语法实现
		p.height = 170;
		p.weight = 120;
		p.name = "冰冰";
		p.callPhone("110");
	}
	
	
}
