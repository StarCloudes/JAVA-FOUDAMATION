package com.qianfeng.practice;

//计算从1到1000以内所有奇数的和并输出。
public class homework07 {
   public static void main(String[] args) {
	  int sum = 0;
	  for(int i = 1; i <= 1000; i++) {
		  if(i % 2 == 1)
			  sum +=i;
	  }
	  System.out.println(sum);
   }
}
