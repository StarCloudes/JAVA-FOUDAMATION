package com.classroom.homework15;
import java.util.ArrayList;
import java.util.Iterator;

public class Demo1 {	
	public static void main(String[] args) {		
		ArrayList list = new ArrayList<>();	
		list.add("python");
		list.add("html");
		list.add("JS");
		list.add("JS");
		
		ArrayList list2 = new ArrayList<>();
		
		//获取第一个迭代器
		Iterator iterator = list.listIterator();
		
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			if(!list2.contains(object)) {
				list2.add(object);
			}
		}
		
		System.out.println(list2);
						
	}                          
}
