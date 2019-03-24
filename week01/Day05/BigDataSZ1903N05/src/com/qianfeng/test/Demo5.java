package com.qianfeng.test;

public class Demo5 {
	public static void main(String[] args) {
		test1();
	}
	static void test1() {
		test2();
		System.out.print("a");
	}
	static void test2() {
		System.out.print("b");
		test5();
	}
	static void test3() {
		System.out.print("d");
		test4();
	}
	static void test4() {
		System.out.print("e");
	}
	static void test5() {
		test3();
		System.out.print("c");
	}
}
