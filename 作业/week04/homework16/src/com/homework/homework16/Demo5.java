package com.homework.homework16;

//线程执行先后顺序问题
class MyThread extends Thread{
	public void run()
	{
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("MyThread running");
	}
}
public class Demo5{

	public static void main(String argv[])
		{
			MyThread t = new MyThread();
			t.run();
			t.start();
			System.out.println("Thread Test");
	    }
}