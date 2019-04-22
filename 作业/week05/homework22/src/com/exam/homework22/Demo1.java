package com.exam.homework22;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;


//创建集合随机获取10个不重复的数字放到ArrayList集合中

public class Demo1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		while(list.size()<=10) {
			int num = new Random().nextInt(100);
			list.add(num);
		}
		ArrayList<Integer> list2 = new ArrayList<>();
		ListIterator<Integer> iterator = list.listIterator();
		while(iterator.hasNext()) {
			int num = iterator.next();
			if(!list2.contains(num)) {
				list2.add(num);
			}else {
				int num2 = new Random().nextInt(100);
				list.add(num2);
			}
		}
		System.out.println(list2);
	}

}
