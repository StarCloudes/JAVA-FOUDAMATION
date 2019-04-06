package com.exam.eighth;
/*
 * 8.创建两个线程模拟下载数据，第一个线程负责下载10张图片，
 * 第二个线程负责下载20条数据，分别休眠20毫秒和10毫秒。观察打印情况。
 */
public class Demo {
	public static void main(String[] args) {
		new Thread(new downloadPic(),"图片线程").start();
		new Thread(new downloadData(),"数据线程").start();
	}
}
class downloadPic implements Runnable{
	@Override
	public void run() {
       for (int i = 1; i <= 10; i++) {
		System.out.println(Thread.currentThread().getName()+"--->下载第"+i+"张图片");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   }
}
class downloadData implements Runnable{
	@Override
	public void run() {
		  for (int i = 1; i <= 20; i++) {
				System.out.println("    "+Thread.currentThread().getName()+"--->下载第"+i+"条数据");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
	}
}