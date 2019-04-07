package com.qianfeng.practice;

//计算从1到1000以内所有能被3或者17整除的数的和并输出。
public class homework08 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 3 == 0 || i % 17 ==0)
				sum += i;
		}
		System.out.println(sum);
	}

}
