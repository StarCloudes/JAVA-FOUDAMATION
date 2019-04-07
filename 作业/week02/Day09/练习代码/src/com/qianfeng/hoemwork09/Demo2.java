package com.qianfeng.hoemwork09;

interface A {
}

class B implements A {
	public String test() {
		return "yes";
	}
}

class Demo2 {
	static A get() {
		return new B();
	}

	public static void main(String[] args) {
		A a = get();
		B b = (B) a;
		System.out.println(b.test());
	}
}