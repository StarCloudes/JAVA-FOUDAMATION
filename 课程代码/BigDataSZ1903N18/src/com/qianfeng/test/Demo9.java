package com.qianfeng.test;
/*
 * join()方法:
 * 原理:线程一旦调用了join方法,他的优先级会高于主线程.主线程会等当前的线程执行完后再去执行.
 * 注意点:优先级只比main线程的高.对其他的线程没有影响.
 */
public class Demo9 {
	public static void main(String[] args) {
		MyTest2 myTest1 = new MyTest2();
		Thread t0 = new Thread(myTest1);
		Thread t1 = new Thread(myTest1);
		t0.start();
		t1.start();
		
		/*
		 * 当线程开始工作后,让t0调用join方法,让他的优先级高于main线程
		 * 注意:join方法必须在线程开始工作后,执行.
		 */
		try {
			t0.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"   主线程"+i);
		}
	}
}

class MyTest2 implements Runnable{
    public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"   子线程"+i);
		}
    }
}