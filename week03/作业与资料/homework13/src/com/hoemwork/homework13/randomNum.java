package com.hoemwork.homework13;

import java.util.ArrayList;
import java.util.Random;

public class randomNum {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<>();
		Random random = new Random();
		int count = 0;
		while(count<10) {
			int a = random.nextInt(19) + 1;
			if(!list.contains(a)) {
				list.add(a);
				count++;
			}
		}
		
	
		
		System.out.println(list);		
	}
}
