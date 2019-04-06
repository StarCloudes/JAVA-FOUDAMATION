package com.exam.second;
/*
 * 2.已知方法原型: MyArrays.getArray(); 能获取到一个全局唯一的MyArrays对象, 实现这个方法
 */
public class MyArrays {
	private MyArrays() {}
	private static final MyArrays m = new MyArrays();
	public static MyArrays getArray() {
		return m;
	}
}
