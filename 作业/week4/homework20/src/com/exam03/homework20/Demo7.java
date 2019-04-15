package com.exam03.homework20;

//设计方法, 实现需求: 输出100以内所有的质数

public class Demo7 {
	public static void main(String[] args) {
		
	}
	
	public static boolean isPrime(int a) {
		if(a < 2) return false;
		for(int i = 2; i * i <= a;i++) {
			if(a % i == 0) return false;
		}
		return true;
	}

}
