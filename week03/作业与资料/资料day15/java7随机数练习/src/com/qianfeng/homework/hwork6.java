package com.qianfeng.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hwork6 {
	public static void main(String[] args) {
		//自定义时间格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日   hh时mm分ss秒");
		String dateStr = dateFormat.format(new Date());
		System.out.println(dateStr);
	}
}
