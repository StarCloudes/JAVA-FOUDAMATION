package com.exam05.homework23;

//编写多线程应用程序，模拟多个人通过一个山洞的模拟。这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
//随机生成10个人，同时准备过此山洞，显示一下每次通过山洞人的姓名。
public class Demo5 {
    public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Mythread thread = new Mythread("0" +i); 
			thread.start();
		}
	}
}

class Mythread extends Thread{
    String name;
	
	
	public Mythread(String name) {
		super();
		this.name = name;
	}

	public synchronized void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Thread.currentThread().getName() + "  通过 " + name);
	}
}
