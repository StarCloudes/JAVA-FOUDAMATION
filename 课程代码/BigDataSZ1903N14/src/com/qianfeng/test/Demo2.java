package com.qianfeng.test;

import java.util.Date;

public class Demo2 {
	public static void main(String[] args) {
		/*
		 * Date:日期类
		 * Data:数据类,表示二进制的数据.
		 */
		//获取当前的时间
		Date date = new Date();
		System.out.println("当前的时间:"+date);
		
		long time =  System.currentTimeMillis(); //获取的系统时间,单位是毫秒
		System.out.println(time);
		
		//时间的转换
		Date date2 = new Date(time);
		System.out.println(date2);
		
		//将时间转成long型的
		System.out.println(date2.getTime());
	
	}
}
