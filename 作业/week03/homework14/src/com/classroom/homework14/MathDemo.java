package com.classroom.homework14;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		
		System.out.println(Math.abs(-4));
		System.out.println(Math.random());
		System.out.println((int)Math.floor(Math.random()*10));
	
	
		//Random class
		Random random = new Random();
		System.out.println(Math.abs(random.nextInt()%10));
		System.out.println(random.nextInt(10));
	}
}
