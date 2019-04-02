package com.qianfeng.test;
/*
 * 异常的特点:程序出现异常的时候,会打印异常的信息并中断程序,所以当有多个异常同时出现的时候,默认只能执行第一个.
 */
public class Demo3 {
	public static void main(String[] args) {
		int[] arr = new int[] {4,5,7};
		System.out.println(arr[10]);//数组下标越界异常  ArrayIndexOutOfBoundsException
		
		arr = null;
		int value = arr[0];//空指针异常   NullPointerException
	}
}
