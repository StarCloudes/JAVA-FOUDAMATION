package com.hoemwork.homework14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Demo4 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<>();
		
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) {
			int a = random.nextInt(20) + 10;
			
			list.add(a);
		}
		
		System.out.println(list);
		
		
		Iterator iterator = list.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			Integer value = (Integer) iterator.next();
			sum += value;
		}
		
		System.out.println(sum);
		
	}

}
