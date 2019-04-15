package com.classroom.homework21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystemException;

//序列化:将短期存储的数据实现长期存储
public class Demo2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObjrct();
		readObject();
	}

	public static void writeObjrct() throws FileNotFoundException, IOException{
        // 创建序列化流对象  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(  
                "text2.txt"));  
        // 创建对象  
        Person p = new Person("林青霞", 27, 100);  
        // public final void writeObject(Object obj)  
        oos.writeObject(p);  
        // 释放资源  
        oos.close();  
	}

	public static void readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 创建反序列化对象  
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(  
                "text2.txt"));  
        // 还原对象  
        Object obj = ois.readObject();  
        // 释放资源  
        ois.close();  
        // 输出对象  
        System.out.println(obj); 
	}

}

class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3935566927965170003L;
	String name;
	int age;
	transient int weight;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age,int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	

}