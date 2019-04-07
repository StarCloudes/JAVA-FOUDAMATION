package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

/*Collection:
 * List:存储的数据是有序的(元素的存储顺序与添加元素的顺序一致),可以重复的.
 * 		Arraylist:底层的数据结构是数组,线程不安全的.特点:查找速度快,添加删除速度慢
 * 		Vector:底层的数据结构是数组,线程安全的.特点:查找速度快,添加删除速度慢
 * 		LinkedList:底层是链表,线程不安全的.特点:查找速度慢,添加删除速度快.
 * Set:存储的数据是无序的,不可以重复
 * 
 * 
 */
public class Demo7 {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		//* List：特有方法，可以操作下标
		//1.增：
		//void add(int index, E element)   在指定位置增加元素
		//boolean addAll(int index, Collection<? extends E> c) 
		list.add("java");
		list.add(0, "html");
		list.add(2, "python");
		System.out.println(list);
		//2.删
		//E remove(int index) 
		//System.out.println(list.remove(0));
		//3.改
	    //E set(int index, E element)
		String string = (String)list.set(0, "iOS");
		System.out.println(list+"   返回值:"+string);
		//4.查
	     //ListIterator<E> listIterator() 
		test(list);
	     //返回此列表元素的列表迭代器（按适当顺序）。 
	     //ListIterator<E> listIterator(int index) 
	     //List<E> subList(int fromIndex, int toIndex)     获取list中 部分元素
	     //E get(int index)   获取指定下标的元素
		     
		//5.删除全部对象
	}
	//4.查
    //ListIterator<E> listIterator() 
	public  static void test(List list) {
		//先获取迭代器对象
		ListIterator iterator = list.listIterator();
		//从左到右的遍历
		while (iterator.hasNext()) {
			String value = (String)iterator.next();
			System.out.println("value:"+value);
		}
		
		System.out.println("*****************************");
		//从右到左遍历
		while (iterator.hasPrevious()) {
			String value = (String)iterator.previous();
			System.out.println("value1:"+value);
		}
		
		//注意点
		while (iterator.hasNext()) {
			String value = (String)iterator.next();
			System.out.println("value:"+value);
			
			//删除java
			if (value.equals("iOS")) {
				//在使用迭代器期间,使用list的删除方法直接删除元素,有可能发生错误,所以不要这样做
				//list.remove("iOS");
				//用迭代器提供的方法,注意:remove,add,set不要同时使用
				iterator.remove();
//				iterator.set("haha");
//				iterator.add("ok");
			}
		}
		
		System.out.println(list);
	}
}
