package com.qianfeng.test;

public class Demo4 {
	public static void main(String[] args) {
		/*
		 * Runtime类:运行时类
		 * 每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。
		 * 可以通过 getRuntime 方法获取当前运行时。 
		      应用程序不能创建自己的 Runtime 类实例。

		 */
		//默认单位是字节
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.freeMemory()/1024./1024.);//空闲的内存量
		System.out.println(runtime.maxMemory()/1024./1024.);//可用的最大内存量
		System.out.println(runtime.totalMemory()/1024./1024.);// 返回 Java 虚拟机中的内存总量
	}
}
