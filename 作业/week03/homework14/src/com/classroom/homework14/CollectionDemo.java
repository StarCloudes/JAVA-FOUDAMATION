package com.classroom.homework14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
	public static void main(String[] args) {

		//Collection中定义是整个集合体系最共性的方法:
		//1.添加：
		//boolean add(Object o) 
		//boolean addAll(Collection<? extends E> c) 
		Collection<Object> collection1 = new ArrayList<>();
		collection1.add("java");
		
		Collection collection2 = new ArrayList<>();
		collection2.add("erlang");
		collection2.add("ios");
		collection1.addAll(collection2);
		
		
		//2.删除:
	    //boolean remove(Object o)  
	    //boolean removeAll(Collection<?> c)
	    //void clear()
//		collection1.remove("java");
//		collection1.removeAll(collection2);
		
		//3.判断:
		//boolean contains(Object o) 
		//boolean containsAll(Collection<?> c)
		//boolean isEmpty() //判断集合是否为空
		//boolean equals(Object o)  
		
		
		//4.获取：迭代器
		//Iterator<E> iterator() //获取集合中的对象
		//int size() //获取集合中对象的个数
		Iterator<Object> iterator = collection1.iterator();	
		while (iterator.hasNext()) {
			String string = (String) iterator.next();	
			System.out.println(string);
		}
		
		//5.集合变数组：
		//Object[] toArray()
	
		System.out.println(collection1);
	}

}
