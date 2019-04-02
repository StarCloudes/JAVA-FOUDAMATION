package com.classroom.code;

public class Demo3 {
	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(true);
		sBuffer.append(false);
		sBuffer.insert(4, "hello");
		System.out.println(sBuffer);
		System.out.println(sBuffer.replace(4, 8, "world"));
		System.out.println(sBuffer.indexOf("world",5));
		System.out.println(sBuffer.reverse());
	}

}
