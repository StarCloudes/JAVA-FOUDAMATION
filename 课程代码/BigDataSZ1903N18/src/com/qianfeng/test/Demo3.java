package com.qianfeng.test;

public class Demo3 {
	public static void main(String[] args) {
		//1.
		Thread t0 = new Thread();
		Thread t1 = new Thread(t0);//相当于将t0作为任务交给了t1
		t0.start();//t0的run方法
		t1.start();//t0的run方法
		
		//2.使用匿名线程对象
		//使用匿名内部类直接开启线程,这里创建了一个新的线程
		new Thread() {
			public void run() {
				System.out.println("haha");
				System.out.println("haha:"+Thread.currentThread().getName());
			}
		}.start();
		//使用匿名线程对象调用普通的run方法,这里没有创建新的线程
		new Thread() {
			public void run() {
				System.out.println("hehe");
				System.out.println("hehe:"+Thread.currentThread().getName());
			}
		}.run();
	}
}
