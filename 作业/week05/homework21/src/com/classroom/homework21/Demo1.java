package com.classroom.homework21;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

//Properties:存储属性的集合，键值都必须是字符串
//
public class Demo1 {
	public static void main(String[] args) throws IOException {
		// 1.properties的基础
		//fun1();
		// 2.获取系统属性
		//fun2();
		// 3.实际应用
        fun3();
	}

	public static void fun1() {
         Properties properties = new Properties();
         properties.setProperty("01", "java");
         properties.setProperty("02", "ios");
         properties.setProperty("03", "html5");
         properties.setProperty("03", "python"); //key
         
         System.out.println(properties);
         System.out.println(properties.getProperty("01"));
         
         //bianli
         Set<String> keys = properties.stringPropertyNames();
         //diedaiqi
         Iterator<String> iterator = keys.iterator();
         while (iterator.hasNext()) {
			String key = (String) iterator.next();
			//System.out.println(properties.getProperty(key));
		 }
         
         //zhuyi
         System.out.println(properties.getProperty("04", "js"));
	}

	public static void fun2() {
		Properties properties = System.getProperties();
		//get name
		Set<String> keys = properties.stringPropertyNames();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key+"   "+properties.getProperty(key));
		 }
        //change value
        properties.setProperty("sun.jnu.encoding", "GBK");
        System.out.println(properties.get("sun.jnu.encoding"));
	}

	public static void fun3() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("text.txt"));
        for(String key: properties.stringPropertyNames()) {
        	System.out.println(key+"   "+properties.getProperty(key));
        }
		properties.setProperty("chenchen", "handsome");
		properties.store(new FileWriter("text.txt"),"first edit");
	}
}
