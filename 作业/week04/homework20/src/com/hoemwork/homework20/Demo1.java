package com.hoemwork.homework20;

import java.io.File;

//1.列出指定目录下满足指定条件的文件的清单
public class Demo1 {
	public static void main(String[] args) {
		File file = new File("/Users/star/code练习/java/JAVA-FOUDAMATION/课程代码/BigDataSZ1903N20");
		// 获取指定目录下的文件或文件夹---1.不包含子文件夹 2.只得到了文件或文件夹的名字,没有全路径
		String[] strings = file.list();
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println("***************************************");

		// 获取指定目录下的文件或文件夹的全路径
		File[] files2 = file.listFiles();
		for (File file7 : files2) {
			System.out.println(file7);
		}
	}

}
