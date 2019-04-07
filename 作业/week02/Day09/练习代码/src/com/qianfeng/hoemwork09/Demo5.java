package com.qianfeng.hoemwork09;

interface A1 {
	void show();
}

interface B1 {
	void add(int a, int b);
}

class C implements A1, B1 {
	// 程序代码

	private int a, b;

	public void add(int a, int b) {
		this.a = a;
		this.b = b;

	}

	public void show() {
		System.out.println(a + b);

	}

}

class Demo5 {
	public static void main(String[] args) {
		C c = new C();
		c.add(4, 2);
		c.show();// 通过该函数打印以上两个数的和。6
	}
}
