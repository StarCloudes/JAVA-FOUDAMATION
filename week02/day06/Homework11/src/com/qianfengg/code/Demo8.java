package com.qianfengg.code;

interface Test1 {
	void func();
}

class Demo8 {
	public static void main(String[] args) {
		show(new Test1() {
			public void func() {
				System.out.print("wode");
			}
		});// 补足代码；(匿名内部类)

	}

	public static void show(Test1 t) {
		t.func();
	}
}