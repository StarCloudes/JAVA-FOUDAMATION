package com.homework.homework17;

//定义一个线程A，输出1 ～ 10之间的整数，
//定义一个线程B，逆序输出1 ～ 10之间的整数，要求线程A和线程B交替输出
public class Homework3 {
	public static void main(String[] args) {
		Output num = new Output();
		MyThread1 thread1 = new MyThread1(num);
		MyThread2 thread2 = new MyThread2(num);

		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		t1.start();
		t2.start();
	}
}

class Output {
	Boolean flag;

	public void showNum() {

		int i = 1;
		while (i <= 10) {
			if (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			i++;
			flag = !flag;
			notify();
		}
	}

	public void showReverseNum() {

		int i = 10;
		while (i >= 1) {
			if (flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			i--;
			flag = !flag;
			notify();
		}
	}
}

class MyThread1 implements Runnable{
	Output output;

	public MyThread1(Output output) {
		this.output = output;
	}

	public void run() {
		synchronized (output) {
			output.showNum();
		}

	}
}

class MyThread2 implements Runnable {
	Output output;

	public MyThread2(Output output) {
		this.output = output;
	}

	public void run() {
		synchronized (output) {
			output.showReverseNum();
		}
	}
}