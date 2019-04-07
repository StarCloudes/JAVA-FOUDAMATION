package com.qianfeng.test;

public class Demo7 {
	public static void main(String[] args) {
		//排序
		//非静态的
		ArrayTools arrayTools = new ArrayTools();
		arrayTools.bubbleSort(new int[] {4,5,6});
		//静态的
		ArrayTools.search(new int[] {4, 5,6},34);
	}
}
