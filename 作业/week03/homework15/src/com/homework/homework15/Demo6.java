package com.homework.homework15;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo6 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		System.out.println(time.format(date));
	}
}
