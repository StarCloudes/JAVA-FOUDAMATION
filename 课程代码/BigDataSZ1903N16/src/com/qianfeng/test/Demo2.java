package com.qianfeng.test;

import java.util.HashMap;
import java.util.Map;

public class Demo2 {
	public static void main(String[] args) {
		/*
		 * Map:接口
		 * 		HashMap:底层是哈希表,线程不安全的
		 * 		TreeMap:底层是二叉树,线程不安全的
		 * 
		 * Collection:直接存储的是值.
		 * Map:本身是接口,存储的是键值对,一个元素就是一个键(key)值(value)对,key必须是唯一的,值随意,即可以重复.
		 * */
		//介绍Map接口的方法
		Map<String, String> map = new HashMap<>();
		//1.增加
		//V put(K key,V value)  增加一个键值对
		map.put("01", "java");
		map.put("02", "php");
		//关于返回值,如果当前的key之前没有添加过,返回null.如果当前的key之前已经存在了,这里返回之前的值
		System.out.println(map.put("02", "iOS"));
		System.out.println(map);//重写了toString方法
		//void putAll(Map<? extends K,? extends V> map)  增加多个
		//2.删除
		//V remove(Object key)  根据key删除元素
		//返回值就是被删掉的值
//		System.out.println(map.remove("01"));
//		//void clear()  删除全部  != null
//		map.clear();
//		System.out.println(map);
		//3.获取
		//V get(Object key)  根据key查找元素
		System.out.println(map.get("java"));
		//int size()  获取键值对的个数
		System.out.println(map.size());
		//Set<K> keySet()   遍历方法一
		//Set<Map.Entry<K,V>> entrySet() 遍历方法二
		//4.常用的判断
		//boolean isEmpty()  //空map!=null
		System.out.println(map.isEmpty());//false
		//boolean containsKey(K key) 是否包含当前的key
		//boolean containsValue(V value) 是否包含当前的value
	}
}
