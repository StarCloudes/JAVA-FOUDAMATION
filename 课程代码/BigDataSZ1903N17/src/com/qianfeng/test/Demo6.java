package com.qianfeng.test;
/*
 * 两个线程的通信
 * 
 * 实例:打印机打印----不断输入不断输出
 * 两个线程:输入线程和输出线程
 * 两个任务区:输入任务,输出任务
 * 一份数据
 */
public class Demo6 {
	public static void main(String[] args) {
		//1.创建了数据对象
		Des des = new Des();
		//2.将数据交给了两个任务
		Input input = new Input(des);
		Output output  = new Output(des);
		//3.创建对象的线程
		Thread inThread = new Thread(input);
		Thread outThread = new Thread(output);
		//4.启动线程
		inThread.start();
		outThread.start();
	}
}
//数据类
class Des{
	String name;
	String sex;
}

//输入任务
class Input implements Runnable{
	Des des;
	public Input(Des des) {
		super();
		this.des = des;
	}
	public void run() {
		int i=0;
		while (true) {
			/*
			 * 需要给输入任务和输出任务同时加一把锁,保证两个任务之间是同步的
			 * 给两个任务加一把锁:可以是des或者Object.class
			 * 分析:
			 * 不建议使用Object.class:由于Object的使用范围太大,可能造成不必要的错误.
			 * 使用des最合适,因为他只被当前的两个任务共享.
			 * 
			 *注意:对于当前的情况只给一个线程加锁,无法实现两个线程的同步.
			 */
			synchronized (des) {
				if (i==0) {
					des.name = "小特";
					des.sex = "男";
				}else {
					des.name = "小三";
					des.sex = "女";
				}
				i=(i+1)%2;
			}
		}
	}
}
//输出任务
class Output implements Runnable{
	Des des;
	public Output(Des des) {
		super();
		this.des = des;
	}
	public void run() {
		while (true) {
			synchronized (des) {
				System.out.println("姓名:"+des.name+"    性别:"+des.sex);
			}
		}
	}
}
