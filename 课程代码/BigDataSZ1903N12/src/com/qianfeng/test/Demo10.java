package com.qianfeng.test;

import java.util.function.Function;

/*
 * 模板设计模式:我们在实现一个功能的时候,功能分成两部分,一部分是确定的,一部分是不确定的.将确定的部分交给当前类实现
 * 				将不确定的部分交给子类实现.子类实现的结果又会反过来影响确定部分的功能.
 * 
 * 实例:计算一个功能的耗时
 * 分析:固定的功能:开始时间,结束时间
 * 不固定的功能:程序运行的时间
 */
public class Demo10 {
    public static void main(String[] args) {
		Zi zi = new Zi();
		long time = zi.getTime();
		System.out.println(time);
	}
}

abstract class Fu{
	public abstract void function();
	//计算功能的运行时间
	public long getTime() {
		//获取开始时间
		long startTime = System.nanoTime();//当前的系统时间   单位是纳秒
		//程序运行的过程
		function();
		//获取结束时间
		long endTime = System.nanoTime();//当前的系统时间   单位是纳秒
		return endTime-startTime;
	}
}

class Zi extends Fu{
	//程序运行时间
	public void function() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i:"+i);
		}
	}
}
