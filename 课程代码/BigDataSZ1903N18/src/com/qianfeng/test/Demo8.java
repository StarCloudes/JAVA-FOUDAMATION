package com.qianfeng.test;
/*
 * 守护线程:相当于后台线程.依赖于前台线程.正常情况下,当前台线程结束的时候,不管守护线程有没有结束,都会立刻结束.
 * 典型的守护线程:垃圾回收线程
 */
public class Demo8 {
	public static void main(String[] args) {
		MyTest1 myTest1 = new MyTest1();
		Thread t0 = new Thread(myTest1);
		/*
		 * 当程序调用setDaemon方法时,并且将参数设置成true.当前线程就变成了守护线层.
		 * 注意:这个方法一定要在start方法之前调用
		 */
		t0.setDaemon(true);
		t0.start();
		
		
		int i=0;
		while (true) {
			if (++i == 10) {
				System.out.println(Thread.currentThread().getName()+"   主线程");
				break;
			}
		}
	}
}

class MyTest1 implements Runnable{
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName()+"   子线程");
		}
	}
}
