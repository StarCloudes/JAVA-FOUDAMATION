package com.qianfeng.test;

import java.util.LinkedList;

public class Demo9 {
	public static void main(String[] args) {
		/*
		 * LinkedList:
		 * 
		 * 
		 * 作业:利用Linkedlist实现队列的功能,根据图实现
		 * 
		 * 明天:
		 * 1.set
		 * 2.泛型
		 * 3.Map
		 */
		LinkedList linkedList = new LinkedList<>();
//		addFirst()//始终在首位添加
//		addLast()//始终在末尾添加
		linkedList.addFirst("java");
		linkedList.addLast("iOS");
		linkedList.addFirst("python");
		linkedList.add(1, "html");
		System.out.println(linkedList);
		linkedList.clear();
//		getFirst()//获取的对象不存在会发生异常   NoSuchElementException
//		getLast()
        //linkedList.getFirst();
//		removeFirst()//删除的对象不存在会发生异常
//		removeLast()

//		从jdk1.6开始出现以下方法
//		offerFirst()
//		offerLast()

//		peekFirst()//获取的对象不存在会返回null
//		peekLast()
		String string = (String)linkedList.peekFirst();
		System.out.println(string);
//		pollFirst()//删除的对象不存在会返回null
//		pollLast()
	}
}
