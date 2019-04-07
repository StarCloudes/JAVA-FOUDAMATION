package com.qianfengg.code;

class Demo4 {
	public static void main(String[] args) {
		try {
			showExce();// 可能发生异常
			System.out.println("A");
		} catch (Exception e) {
			System.out.println("B");
		} finally {
			System.out.println("C");
		}
		System.out.println("D");
	}

	public static void showExce() throws Exception {
		throw new Exception();
	}
}
