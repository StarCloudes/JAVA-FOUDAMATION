package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * List的注意点:
 * 例题:List是有序可重复的
 * 要求:使用List存储数据,但是数据不能重复----利用Contains
 */
public class Demo2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add("java");
		list.add("php");
		list.add("php");
		list.add("html");
		list.add("python");
		System.out.println(list);
		
		//去重
		//让他去存储去重后的数据
		ArrayList list1 = new ArrayList<>();
		//获取第一个list的迭代器
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			//当list1中不包换object时,将它添加进来
			/*
			 * 如果判断成立,说明list1中不包含当前的元素
			 * 工作原理:当添加元素时,会让当前的元素与集合中已有的元素通过equels方法进行一一比较.过程中
			 * 只要有一次返回true,停止比较.让整个的contains方法返回true.只有所有的比较都返回false,最终
			 * 才会返回false
			 * 
			 * 实例:添加第三个元素的时候,调用equals方法的过程
			 * 第三元素.equals("java") = false     第三元素.equals("php") = true  停止比较
			 * 
			 */
			if (!list1.contains(object)) {
				list1.add(object);
			}
		}
		System.out.println("去重后的结果:"+list1);
	}
}
