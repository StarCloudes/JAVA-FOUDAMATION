package com.classroom.homework17;

public class Demo1 {
	public static void main(String[] args) {
//		Thread thread1 = new Thread(); //one main thread
//		thread1.start(); // two threads
//		thread1.run();
		TestThread test1 = new TestThread("小白"); // one main thread
		TestThread test2 = new TestThread("小鸡"); // one main thread

		//test1.start(); // two threads
		test2.start();
		test1.run();//变成普通的方法在main线程

		System.out.println(Thread.currentThread().getName()+ " main go");
	}

}

class TestThread extends Thread {
	String mynameString;
		
	public TestThread(String mynameString) {
		super();
		this.mynameString = mynameString;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()+ "  run" + mynameString);
	}
}



