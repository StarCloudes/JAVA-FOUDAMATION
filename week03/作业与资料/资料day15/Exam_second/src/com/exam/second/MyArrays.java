package com.exam.second;
/*
 * 2.��֪����ԭ��: MyArrays.getArray(); �ܻ�ȡ��һ��ȫ��Ψһ��MyArrays����, ʵ���������
 */
public class MyArrays {
	private MyArrays() {}
	private static final MyArrays m = new MyArrays();
	public static MyArrays getArray() {
		return m;
	}
}
