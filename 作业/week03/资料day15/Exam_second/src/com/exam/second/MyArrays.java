package com.exam.second;

//已知方法原型: MyArrays.getArray(); 
//能获取到一个全局唯一的MyArrays对象, 实现这个方法

public class MyArrays {
	private MyArrays() {}
	
	private static  MyArrays m = null;
	
	public static MyArrays getArray() {
		if(m == null) {
			 m = new MyArrays();
		}
		return m;
	}
}
