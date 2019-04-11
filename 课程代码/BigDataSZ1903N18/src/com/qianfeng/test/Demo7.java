package com.qianfeng.test;
/*
 * 线程的停止:3种
 * 1.通过一个标识结束线程
 * 2.调用stop方法---因为有固有的安全问题,所以系统不建议使用.
 * 3.调用interrupt方法----如果目标线程等待很长时间（例如基于一个条件变量），则应使用 interrupt 方法来中断该等待。
 */
////1.通过一个标识结束线程
//public class Demo7 {
//	public static void main(String[] args) {
//		MyTest myTest = new MyTest();
//		Thread t0 = new Thread(myTest);
//		t0.start();
//		
//		try {//让主线程休息一会儿
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		int i=0;
//		while (true) {
//			if (++i == 10) {//当i==10的时候,我就让子线程结束,让flag=false
//				myTest.flag = false;
//				
//				break;//这里是让主线程结束
//			}
//		}
//	}
//}
//
//class MyTest implements Runnable{
//	boolean flag = true;
//	public void run() {
//		while (flag) {
//			System.out.println(Thread.currentThread().getName()+"   今天周三");
//		}
//	}
//}

//3.调用interrupt方法----如果目标线程等待很长时间（例如基于一个条件变量），则应使用 interrupt 方法来中断该等待。
public class Demo7 {
	public static void main(String[] args) {
		MyTest myTest = new MyTest();
		Thread t0 = new Thread(myTest);
		t0.start();
		
		try {//让主线程休息一会儿
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i=0;
		while (true) {
			if (++i == 10) {//当i==10的时候,我就让子线程结束,直接调用interrupt方法
				t0.interrupt();
				
				break;//这里是让主线程结束
			}
		}
	}
}

class MyTest implements Runnable{
	boolean flag = true;
	public synchronized void run() {//要想使用唤醒等待必须是在同步的环境下
		while (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				flag = false;
			}
			System.out.println(Thread.currentThread().getName()+"   今天周三");
		}
	}
}

