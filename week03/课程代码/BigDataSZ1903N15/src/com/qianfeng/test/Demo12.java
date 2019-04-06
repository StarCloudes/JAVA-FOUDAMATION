package com.qianfeng.test;
/*
 * 周一的内容
 * 1.Map
 * 2.Map的注意点
 * 3.一些常用的工具类
 * 4.可变参数
 * 5.多线程基础
 */
import java.util.Comparator;
import java.util.TreeSet;

public class Demo12 {
	public static void main(String[] args) {
		//限制下限 <? super E>
		//TreeSet(Comparator<? super E> comparator) :这里的E跟TreeSet后面的泛型类型一致,所以现在E应该表示的Student3
		
		//创建Student3类的比较器对象
		ComWithStu comWithStu = new ComWithStu();
		//创建Teacher1类的比较器对象
		ComWithTea comWithTea = new ComWithTea();
		//创建Person1类的比较器对象
		ComWithPerson1 comWithPerson = new ComWithPerson1();
		//创建GoodStudent类的比较器对象
		ComWithGood comWithGood = new ComWithGood();
		
		TreeSet<Student3> set = new TreeSet<>(comWithStu);//因为这里限制的是Student3及他的父类
		//TreeSet<Student3> set = new TreeSet<>(comWithTea);//不可以使用,因为Teacher2类与Student3类没有关系
		//TreeSet<Student3> set = new TreeSet<>(comWithPerson);//可以  ,因为Person3类是Student3类的父类
		//TreeSet<Student3> set = new TreeSet<>(comWithGood);//不可以,因为GoodStudent类是Student3类的子类
		set.add(new Student3("bingbing"));
		set.add(new Student3("bingbing1"));
		set.add(new Student3("bingbing2"));
	}
}
//创建Student3类的比较器
class ComWithStu implements Comparator<Student3>{

	public int compare(Student3 o1, Student3 o2) {
		
		return o1.name.compareTo(o2.name);
	}
}
//创建Teacher2类的比较器
class ComWithTea implements Comparator<Teacher2>{
	public int compare(Teacher2 o1, Teacher2 o2) {
		
		return 0;
	}
}
//创建Person2类的比较器
class ComWithPerson1 implements Comparator<Person3>{
	@Override
	public int compare(Person3 o1, Person3 o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

//创建GoodStudent类的比较器
class ComWithGood implements Comparator<GoodStudent>{
	public int compare(GoodStudent o1, GoodStudent o2) {
		return 0;
	}
}

class Person3{
	 String name;

	public Person3(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return "Person3 [name=" + name + "]";
	}
}

class Teacher2 extends Person3{
	public Teacher2(String name) {
		super(name);
	}
}
class Student3 extends Person3{
	public Student3(String name) {
		super(name);
	}
}

class GoodStudent extends Student3{
	public GoodStudent(String name) {
		super(name);
	}
}


