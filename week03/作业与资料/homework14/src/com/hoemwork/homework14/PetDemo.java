package com.hoemwork.homework14;

import java.util.ArrayList;
import java.util.ListIterator;

import com.sun.org.apache.bcel.internal.generic.NEW;

//练习:我养了三条狗关在01房间,两只猫关在02房间,将他们存放起来并遍历
//* 字符串:    拉布拉多;4;20 : 黑贝;3;10 : 茶杯犬;1;10 & 波斯猫;10;10 : 加菲猫;30;20

public class PetDemo {
	public static void main(String[] args) {
		String string = "拉布拉多;4;20:黑贝;3;10:茶杯犬;1;10&波斯猫;10;10:加菲猫;30;20";
		splitPet(string);
	}

	public static void splitPet(String s) {
		String s1 = s.split("&")[0];
		ArrayList Room1 = new ArrayList<>();
		getRoom(s1, Room1);
		System.out.println("Room1————————————————");
		introduce(Room1);
		//System.out.println(Room1);

		String s2 = s.split("&")[1];
		ArrayList Room2 = new ArrayList<>();
		getRoom(s2, Room2);
		System.out.println("Room2————————————————");
		introduce(Room2);
		//System.out.println(Room2);

	}

	public static void getRoom(String s, ArrayList list) {
		for (int i = 0; i < s.split(":").length; i++) {
			String[] arr = s.split(":")[i].split(";");
			String name = arr[0] ;
			int year = Integer.parseInt(arr[1]);
			int height =Integer.parseInt(arr[2]);
			list.add(new Pet(name,year, height));	
		}
	}

	public static void introduce(ArrayList room) {
		for (int i = 0; i < room.size(); i++) {
			System.out.println(room.get(i));
		}
	}

}

class Pet{
	private String name;
	private int year;
	private int height;

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

	public Pet() {
	}

	public Pet(String name, int year, int height) {
		this.name = name;
		this.year = year;
		this.height = height;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", year=" + year + ", height=" + height + "]";
	}
	
	
}
