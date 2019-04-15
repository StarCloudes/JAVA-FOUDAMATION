package com.qianfeng.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/*
 * Properties:实际上就是Map集合,存储的是属性,属性以键值对的方式存储.这里的键和值都必须是字符串.
 * 
 * 为什么要在这里讲Properties?
 * 因为他的使用与流紧密相关
 * 
 * 优点:
 * 1.以键值对的形式存储数据
 * 2.内部针对属性的存储封装了大量的专有方法:load,store,list
 */
public class Demo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//1.Properties的基础
		//fun1();
		//2.使用Properties获取系统属性
		//fun2();
		//3.Properties的实际应用
		fun3();
	}
	//1.Properties的基础
	public static void fun1() {
		//键和值都必须是字符串,所以不用写泛型
		Properties properties = new Properties();
		//存值
		properties.setProperty("01", "java");
		properties.setProperty("02", "html");
		//取值
		System.out.println(properties.getProperty("01"));
		//也有map的特点:key不能重复,后面的值会将前面的值覆盖
		properties.setProperty("02", "iOS");
		System.out.println(properties.getProperty("02"));
		//取出里面所有的key
		Set<String> keys = properties.stringPropertyNames();
		//第一种使用迭代器
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println("value:"+properties.getProperty(key));
		}
		//第二种foreach
		
		//注意点:当key不存在的时候,返回的是默认值
		String value = properties.getProperty("03", "python");
		System.out.println("myvalue:"+value);
	}
	//2.使用Properties获取系统属性
	public static void fun2() {
		Properties properties = System.getProperties();
		//先获取属性的名字
		Set<String> keys = properties.stringPropertyNames();
//		Iterator<String> iterator = keys.iterator();
//		while (iterator.hasNext()) {
//			String key = (String) iterator.next();
//			System.out.println("key:"+key+"    value:"+properties.getProperty(key));
//		}
		//改变内部的值
		properties.setProperty("sun.jnu.encoding", "utf-8");
		System.out.println("value:"+properties.get("sun.jnu.encoding"));
		
		//再获取一遍
	//原理:会先到内存中找属性集合的对象,如果有,直接使用.如果没有,会重新初始化一个新的对象,并获取属性集合.
		Properties properties1 = System.getProperties();
		System.out.println("value1:"+properties1.get("sun.jnu.encoding"));
	}
	//3.Properties的实际应用
	public static void fun3() throws FileNotFoundException, IOException {
		//创建Properties对象
		Properties properties = new Properties();
		//从文件中读取内容---使用load方法加载
		properties.load(new FileReader("D:\\workspace\\BigDataSZ1903N21\\test4.txt"));
		//遍历
		Set<String> keys = properties.stringPropertyNames();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = (String)it.next();
			System.out.println("value:"+properties.getProperty(key));
		}
		//将内容进行更改
		properties.setProperty("bingbing", "chou");
		//将更改的内容写会文件,第二个参数是说明信息
		properties.store(new FileWriter("D:\\workspace\\BigDataSZ1903N21\\test4.txt"), "将piaoliang变成了chou");
		//将内容打印到控制台
		properties.list(System.out);
	}
}
