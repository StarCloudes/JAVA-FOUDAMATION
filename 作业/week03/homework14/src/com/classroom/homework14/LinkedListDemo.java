package com.classroom.homework14;
import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList<>();
		linkedList.addFirst("java");
		linkedList.addFirst("ios");
		linkedList.addFirst("python");
		linkedList.add(1,"html");
		//addFirst()//始终在首位添加
		//addLast()//始终在末尾添加
		
		//getFirst()//获取的对象不存在会发生异常
		//getLast()

		//removeFirst()//删除的对象不存在会发生异常
		//removeLast()

		//从jdk1.6开始出现以下方法
		//offerFirst()
		//offerLast()
		linkedList.pollFirst();
		//peekFirst()//获取的对象不存在会返回null
		//peekLast()

		//pollFirst()//删除的对象不存在会返回null
		//pollLast()
		
		System.out.println(linkedList);
		System.out.println(linkedList.getFirst());
		
	}

}
