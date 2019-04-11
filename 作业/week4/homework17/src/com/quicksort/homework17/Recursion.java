package com.quicksort.homework17;

//递归（recursion） 自己调用自己
//从前有座山，山里有座庙，庙里有个老和尚，正在给小和尚讲故事呢！
//故事是什么呢？「从前有座山，山里有座庙，庙里有个老和尚，正在给小和尚讲故事呢！
//故事是什么呢？『从前有座山，山里有座庙，庙里有个老和尚，正在给小和尚讲故事呢！故事是什么呢？……』」

//递归：常常用”整体“的思想

//我们要记住的是，想要用递归必须知道两个条件：
//
//递归出口(终止递归的条件)
//递归表达式(规律)

public class Recursion {

	public static void main(String[] args) {
		System.out.println("和：" + sum(100));
	}
	
//	如果n=1时，那么就返回1           sum（1） = 1
//	如果n=2时，那么就返回3(1+2)      sum（2） = sum（1）+ 2
//  如果n=3时，那么就返回6(1+3+2)    sum（3） = sum（2）+ 3
//	                              sum（n） = sum（n-1）+ n
//	最简单的递归出口了：if(n=1) return 1
	
	public static int sum(int n) {
		if (n == 1) {  //递归出口
			return 1;
		} else {     
			return sum(n - 1) + n; //递归表达式
		}
	}
}
