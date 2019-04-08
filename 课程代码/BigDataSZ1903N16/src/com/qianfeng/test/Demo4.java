package com.qianfeng.test;

import java.util.HashMap;

/*
 * HashMap:去重,因为HashMap的底层与HashSet的底层实现一样,只是对HashMap去重的时候,操作的是key
 * 作业:实现字符串和Person对象的去重
 * 
 * 注意:HashMap可以实现排序:因为他的底层数据结构是由数组+链表+二叉树共同实现的.所以可以排序.同时这样做的目的是提高数据存储的效率.
 */
/*
 * HashMap
 * 经常出的相关面试题
 * 1.HashMap的底层实现
 * 2.HashMap与HashTable的区别
 */
public class Demo4 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		//String已经默认重写了hashCode和equals方法,所以map中的key可以自动去重
		map.put("01", "java1");
		map.put("07", "java2");
		map.put("06", "java3");
		map.put("04", "java4");//这个值会被覆盖
		map.put("04", "java5");
		System.out.println(map);
	}
}
