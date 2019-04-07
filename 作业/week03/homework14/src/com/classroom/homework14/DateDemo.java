package com.classroom.homework14;

import java.util.Calendar;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateDemo {
	public static void main(String[] args) {
		//获取当前时间
		Date date = new Date();
		System.out.println("当前时间"+date);
		
		long time = System.currentTimeMillis();
		System.out.println("系统时间"+time);
		
		//时间转化
		Date date2 = new Date(time);
		System.out.println("转换时间"+date2);
		
		//System.out.println(date2.getTime());
		//System.out.println(date.getDay());
		
		
		//日期格式转换器
		//系统默认
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
		String date3 = dateFormat.format(date);
		System.out.println("system: "+date3);
		
		//自定义
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date4 = simpleDateFormat.format(date);
		System.out.println("self: "+date4);
		
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		}


}
