package com.hoemwork.homework14;

import java.util.ArrayList;

//2.有某个字符串集合，长度为10，给定字母a，统计集合中的字符串元素包含字母a的个数。

public class Demo2 {
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add("abc");
		list.add("acd");
		list.add("xyz");
		list.add("bbq");
		list.add("jack");
		int count = 0;
		for (Object string : list) {
			if (string.toString().contains("a")) {
				count++;
			}
		}
		System.out.println(count);
	}

}
