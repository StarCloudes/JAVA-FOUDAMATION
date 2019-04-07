package com.qianfeng.test;

import java.util.Random;

/*
 * Math:数学计算类
 */
public class Demo4 {
	public static void main(String[] args) {
		System.out.println(Math.abs(-4));//求绝对值
		System.out.println(Math.sqrt(2));//求平方根
		System.out.println(Math.cbrt(3));//求立方根
		System.out.println(Math.floor(3.4));//向下取整
		System.out.println(Math.ceil(3.4));//向上取整
		System.out.println(Math.random());//求随机数  [0,1)
		
		//实例:取[0,10)之间的整数
		System.out.println((int)Math.floor(Math.random()*10));
		
		//Random类
		//实例:取[0,10)之间的整数
		Random random = new Random();
		System.out.println(Math.abs(random.nextInt()%10));
		System.out.println(random.nextInt(10));
	}
}
