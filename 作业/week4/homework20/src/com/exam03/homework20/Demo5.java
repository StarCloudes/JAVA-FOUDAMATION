package com.exam03.homework20;

//设计一个方法, 判断一个数字是不是水仙花数
//水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。

public class Demo5 {
	public static void main(String[] args) {
		int a = 198;
		int ge = a % 10;
		int shi = a /10 % 10;
		int bai = a /100 % 10;
		int sum = ge * ge * ge + shi* shi* shi+ bai* bai* bai;
		if(sum == a) {
			System.out.println("是水仙花数");
		}else {
			System.out.println("不是水仙花数");
		}
		
	}

}
