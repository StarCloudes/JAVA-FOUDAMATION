package com.qianfeng.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Set<K> keySet()   遍历方法一

//原理:先得到所有的key,放入一个Set中,利用Set的迭代器进行遍历得到key,在利用key获取value

//Set<Map.Entry<K,V>> entrySet() 遍历方法二
// 原理:先得到所有的entry,放入一个Set中,利用Set的迭代器进行遍历得到entry实体,在利用entry的方法获取key和value
public class Demo3 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("01", "java1");
		map.put("02", "java2");
		map.put("03", "java3");
		map.put("04", "java4");
		map.put("05", "java5");
		System.out.println(map);
		
		//使用keySet进行遍历
		//1.得到装着key的set集合
		Set<String> set = map.keySet();
		//2.对set进行遍历
		Iterator<String> iterator1 = set.iterator();
		while (iterator1.hasNext()) {
			String key = (String) iterator1.next();
			System.out.println("key:"+key+"    value:"+map.get(key));
		}
		
		//使用entrySet进行遍历
		//1.得到装着entry的set集合
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		//2.对set进行遍历
		Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry<String, String> entry =  iterator2.next();
			entry.setValue("haha");
			System.out.println("key1:"+entry.getKey()+"    value1:"+entry.getValue());
		}
		//通过setValue可以将map的原始值改变,但是一般在使用entrySet的时候,是进行遍历.不进行值的改变.
		System.out.println("临时:"+map);
	}
}
