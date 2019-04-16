package com.exam.homework22;

//已知字符串"xiaoming,男,20岁,172cm,65kg,99分", 设计相关的类, 并从这个字符串中取出数据给相关的属性赋值
public class Demo2 {
	public static void main(String[] args) {
		String string = "xiaoming,20,172,65,99";
		String[] arr = string.split(",");
		Person person = new Person(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
		System.out.println(person);
	}

}

class Person{
	private String name;
    private int year;
    private int height;
    private int weight;
    private int mark;
    
    
	public Person() {
		super();
	}
	
	
	public Person(String name, int year, int height, int weight, int mark) {
		super();
		this.name = name;
		this.year = year;
		this.height = height;
		this.weight = weight;
		this.mark = mark;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}

	public String toString() {
		return "Person [name=" + name + ", year=" + year + "岁, height=" + height + "cm, weight=" + weight + "kg, mark="
				+ mark + "分]";
	}
    
}
