package com.qianfeng.test;
/*
 * 问题描述：
 * 	有一对小兔子，从出生后第三个月起，每个月都生一对 小兔子，
 * 	小兔子长到第三个月后 又每个月生一对小兔子
 * 	假如兔子都不死，直到20个月
 * 	问，每个月的兔子对数是多少？
 */
 /*
 * 分析：
 * 	首先，明确题意，要求每个月的兔子“总对数”。我们可以将兔子分成三个成熟阶段
	1.小兔子（一个月），还不能够繁殖
	2.成年兔子（两个月大），下个月可以繁殖
	3.老兔子（三个月及上个月以上大），每个月都可以繁殖
 */
public class Rabbit {
	public static void main(String[] args) {
		System.out.println(Fibnacci(1000));
//		for(int i=1; i<=5; i++) {
//			System.out.print(i+"月：\t"+Fibnacci(i)+"\t");
//			if(i%5==0)
//				System.out.println();
//		}
		
		System.out.println(sum(1000));
	}
	
	//递归的方法
	public static int Fibnacci(int month) {
		if(month==1 || month==2) {
			return 1;
		}else {
			return Fibnacci(month-1)+Fibnacci(month-2);
		}
	}
	
	//普通递推法
	public static int sum(int month) {
		int i=1, j=1, sum=1;
		for(int k=1; k <= month-2; k++) {
			sum = i+j;
			i = j;
			j = sum;
		}
		return sum;
	}
}
