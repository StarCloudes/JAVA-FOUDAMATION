package com.Test;
//每个线程打印4个：左手是一个线程负责画"□"，右手也是一个线程负责画”O”，左每画一个睡300，右每画一个睡200
public class Test6 {
	public static void main(String[] args) {
		PrintA a = new PrintA();
		PrintB b = new PrintB();
		a.start();
		b.start();
	}
}
class PrintA extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.print("□");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class PrintB extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.print("O");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}