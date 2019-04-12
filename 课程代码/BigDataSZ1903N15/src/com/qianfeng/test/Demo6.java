package com.qianfeng.test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet的第二种排序去重方法
 * 
 * 使用实现了Comparator接口的compare()方法的比较器对象进行比较
 * 
 * 总结:一个有两种方式
 * 第一种让元素实现Comparable接口----默认排序
 * 第二种创建实现了Comparator接口的比较器----人工排序
 * 
 * 注意:人工排序的优先级高于默认排序
 * 
 *练习:将人存入TreeSet,通过Comparator实现Person2的排序和比较
 *规则:只要姓名和年龄相同认为是一个人
 */
public class Demo6 {
	public static void main(String[] args) {
		//2.创建比较器对象
		ComWithLength comWithLength = new ComWithLength();
		//3.通过参数交给TreeSet
		Set set = new TreeSet<>(comWithLength);
	   	 /*
	   	  * TreeSet的add方法实现的排序,去重.通过调用元素的compareTo方法
	   	  * String类已经实现了Comparable接口
	   	  */
			set.add("java");
			set.add("iOS");
			set.add("iiOS");
			set.add("php");
			set.add("python");
			set.add("java");
			System.out.println(set);
			
			ComWithPerson comWithPerson = new ComWithPerson();
			Set set1 = new TreeSet<>(comWithPerson);

			set1.add(new Person2("bingbing", 290));
			set1.add(new Person2("chenchen", 20));
			set1.add(new Person2("zhasan", 290));
			set1.add(new Person2("chenchen", 20));
		
			System.out.println(set1);
	}
}

//1.创建一个比较器
//按照字符串的长度比较
class ComWithLength implements Comparator{

	public int compare(Object o1, Object o2) {
		if (!(o1 instanceof String)) {
			throw new ClassCastException("当前的对象不是String的对象");
		}
		if (!(o2 instanceof String)) {
			throw new ClassCastException("当前的对象不是String的对象");
		}
		//向下转型
		String s1 = (String)o1;
		String s2 = (String)o2;
		
		int num = s1.length()-s2.length();
		return num==0?s1.compareTo(s2):num;
	}
}
//自定义的比较规则,按照姓名和年龄比较
class ComWithPerson implements Comparator{
	
	public int compare(Object o1, Object o2) {
		if (!(o1 instanceof Person2)) {
			throw new ClassCastException("当前的对象不是Person2的对象");
		}
		if (!(o2 instanceof Person2)) {
			throw new ClassCastException("当前的对象不是Person2的对象");
		}
		//向下转型
		Person2 p1 = (Person2)o1;
		Person2 p2 = (Person2)o2;
		
		int num = p1.age-p2.age;
		return num==0?p1.name.compareTo(p2.name) : num;
	}
}
