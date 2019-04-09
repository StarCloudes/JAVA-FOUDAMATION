package com.homework.homework17;

//张三和妻子各拥有一张银行卡和存折，可以对同一个银行账户进行存取款的操作，请使用多线程及同步方法模拟张三和妻子同时取款的过程。
//要求使用同步方法和同步代码块两种方式实现
//分析
//定义Account类表示银行帐户
//定义两个线程分别实现张三和妻子取款的操作

public class Homework4 {
	public static void main(String[] args) {
		Account account = new Account();
		SaveMoney save = new SaveMoney(account);
		GetMoney get = new GetMoney(account);
		
		Thread thread1 = new Thread(save);
		Thread thread2 = new Thread(save);
		Thread thread3 = new Thread(get);
		Thread thread4 = new Thread(get);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

class Account{
	int sum=1000;
	
	public synchronized void save(){
		sum+=1000;
		System.out.println(Thread.currentThread().getName()+"存钱"+sum+"元");
	}
	
	public synchronized void get(){
		if(sum>0){
			sum-=100;
			System.out.println(Thread.currentThread().getName()+"取钱100元");
		}
	}
}

class SaveMoney implements Runnable{
	Account account;
	int i=1;
	Object obj=new Object();
	
	SaveMoney(Account account){
		this.account=account;
	}
	public void run(){
		synchronized (obj) {
			while(i<=10){			
				account.save();				
				i++;
			}
		}		
	}	
}

class GetMoney implements Runnable{
	Account account;
	int i=1;
	Object obj=new Object();
	
	GetMoney(Account account){
		this.account=account;
	}
	public void run(){
		synchronized (obj) {
			while(i<=10){			
				account.get();				
				i++;
			}
		}		
	}	
}


