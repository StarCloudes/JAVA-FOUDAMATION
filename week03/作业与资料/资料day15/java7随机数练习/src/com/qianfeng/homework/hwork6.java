package com.qianfeng.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hwork6 {
	public static void main(String[] args) {
		//�Զ���ʱ���ʽ
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd��   hhʱmm��ss��");
		String dateStr = dateFormat.format(new Date());
		System.out.println(dateStr);
	}
}
