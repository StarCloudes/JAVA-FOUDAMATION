package com.qianfeng.test;
/*
 * 默认情况下,主线程和垃圾回收线程都是由系统创建的,但是我们需要完成自己的功能----创建自己的线程对象
 * java将线程面向对象了,形成的类就是Thread,在Thread类内部执行任务的方法叫run()
 * 
 * 注意:如果想让run作为任务区,必须让他去被自动调用.我们通过执行start()方法,来实现run方法的调用.
 * 
 * 主线程的名字:main   子线程的名字:从Thread-0开始命名
 */
public class Demo2 {
//	public static void main(String[] args) {//以后研究的时候,暂时忽略垃圾回收线程.     一个主线程
//		//1.直接使用Thread创建线程对象
//		//分析:由于我们实现的实际功能Thread类是决定不了的,所以没有办法将我们的功能放入Thread的run方法里
//		//所以Thread的run 方法是一个空方法.如果我们想实现自己的功能,可以写Thread类的子类,重写run方法
//		Thread thread1 = new Thread();//创建了一个线程对象
//		//执行start方法,开启线程
//		thread1.start();//两个线程
//		
//		System.out.println("main");
//	}
	
	public static void main(String[] args) {//以后研究的时候,暂时忽略垃圾回收线程.     一个主线程
		//2.使用Thread的子类创建线程对象
		
		MyThread thread0 = new MyThread("t0");//创建了一个线程对象
		MyThread thread1 = new MyThread("t1");
		//执行start方法,开启线程
		thread0.start();//两个线程
		thread1.start();//三个线程
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" main:"+"    i:"+i);
		}
		//当我们手动调用run的时候,他失去了任务区的功能,变成了一个普通的方法.
		//当run作为一个普通方法时,内部对应的线程跟调用他的位置保持一致.
		thread0.run();
	}
}

class MyThread extends Thread{
	String myname;
	public MyThread(String myname) {
		super();
		this.myname = myname;
	}
	//重写run方法,实现我们的功能.run就是我们的任务区
	/*
	 * Thread.currentThread():获取的是当前的线程
	 * Thread.currentThread().getName():线程的名字
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" run:"+myname+"    i:"+i);
		}
	}
}
