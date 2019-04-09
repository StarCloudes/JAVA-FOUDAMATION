package com.qianfeng.test;
/*
 * 实现四个售票员售票
 * 将四个售票员看做四个线程
 * 数据:一份
 * 
 * 实现多线程的方式两种:
 * 第一种方式:通过创建Thread子类的方式实现功能----线程与任务绑定在了一起,操作不方法
 * 第二种:将任务从线程中分离出来,哪个线程需要工作,就将任务交给谁,操作方便
 */
 
//创建子类的方式实现
//public class Demo3 {
//	public static void main(String[] args) {
//		//1.创建四个线程
//		SubThread t0 = new SubThread();
//		SubThread t1 = new SubThread();
//		SubThread t2 = new SubThread();
//		SubThread t3 = new SubThread();
//		
//		//2.调用start方法,开启线程
//		t0.start();
//		t1.start();
//		t2.start();
//		t3.start();
//	}
//}
//
//class SubThread extends Thread{
//  为了让四个线程共享同一个数据
//	static int sum = 20;
//	public void run() {
//		for (int i = 0; i < 5; i++) {
//			System.out.println("sum:"+ --sum);
//		}
//	}
//}

//让线程与任务分离
//这里Thread内部默认有一个run,又通过ticket传入一个run,为什么优先调用的是传入的run
//如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。
public class Demo3 {
	public static void main(String[] args) {
		//0.创建任务对象
		ticket ticket = new ticket();
		
		//1.创建四个线程,并且与独立的任务对象关联
		Thread t0 = new Thread(ticket);
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		
		//2.调用start方法,开启线程
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}

//创建任务对象
class ticket implements Runnable{
    int sum = 20;
    boolean flag = true;
	public void run() {
		//让当前的线程暂时休息一会儿
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (flag) {
			if (sum>0) {
				System.out.println(Thread.currentThread().getName()+"  sum:"+ --sum);
			}else {
				flag = false;
			}
		}
	}
}