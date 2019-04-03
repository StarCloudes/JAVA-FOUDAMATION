package com.qianfeng.test;

import java.util.Enumeration;
import java.util.Vector;

/*
 * 练习:我养了三条狗关在01房间,两只猫关在02房间,将他们存放起来并遍历
 * 字符串:    拉布拉多;4;20:黑贝;3;10:茶杯犬;1;10&波斯猫;10;10:加菲猫;30;20
 */
// 字符串:    拉布拉多;4;20:黑贝;3;10:茶杯犬;1;10&波斯猫;10;10:加菲猫;30;20
/*
 * Vector:  了解
 * 遍历的时候,使用的是枚举器
 */
public class Demo8 {
	public static void main(String[] args) {
		Vector vector = new Vector<>();
		vector.add("java");
		vector.add("html");
		vector.add("iOS");
		
		//遍历
		//创建枚举器对象
		Enumeration enumeration =  vector.elements();
		while (enumeration.hasMoreElements()) {
			String value =  (String)enumeration.nextElement();
			System.out.println(value);
		}

	}
}
