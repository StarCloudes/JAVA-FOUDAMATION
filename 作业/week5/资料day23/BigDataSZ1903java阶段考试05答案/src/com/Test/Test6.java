package com.Test;
//ÿ���̴߳�ӡ4����������һ���̸߳���"��"������Ҳ��һ���̸߳��𻭡�O������ÿ��һ��˯300����ÿ��һ��˯200
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
			System.out.print("��");
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