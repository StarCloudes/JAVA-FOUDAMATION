package com.classroom.homework17;

//两个人向同一个账户存钱

public class Demo3 {
	public static void main(String[] args) {
		SaveMOney bank = new SaveMOney();
		Thread thread1 = new Thread(bank);
		Thread thread2 = new Thread(bank);
		thread1.start();
		thread2.start();
	}

}

class BankAccount {
	int sum = 0;

//	public void addMoney(int money) {
//		synchronized (this) {
//			sum += money;
//			System.out.println(sum);
//		}
//	}
	public synchronized void addMoney(int money) {
		sum += money;
		System.out.println(sum);
	}
}

class SaveMOney implements Runnable {
	BankAccount account = new BankAccount();
	Object obj;

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			account.addMoney(200);
		}
	}
}
