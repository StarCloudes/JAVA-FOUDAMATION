package com.qianfeng.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 日期转换---日期格式转换器
 * Format:格式转换器
 * DateFormat:日期格式转换器
 */
public class Demo3 {
	public static void main(String[] args) {
		//1.使用系统提供的默认的格式-DateFormat--提供了四种可选模式:short,long,full,default
		//第一个参数用于指定日期格式   第二个参数用于指定时间格式
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL);
		String date1 = dateFormat.format(new Date());
		System.out.println(date1);
		//2.使用自定义的格式---SimpleDateFormat----必须会
		//1990-12-10  23:23:23
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//HH表示24小时制
		String date2 = simpleDateFormat.format(new Date());
		System.out.println(date2);
		
		//日历类----自己看
		Calendar calendar = Calendar.getInstance();
	}
}
