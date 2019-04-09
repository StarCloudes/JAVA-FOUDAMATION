package com.qianfeng.test;
/*
 * 实例:两个人同时向银行同一个账户存钱
 * 两个人---两个线程     一份数据
 
  * 比较同步代码块儿和同步函数
 * 同步代码块儿使用更加的灵活,只给需要同步的部分代码同步即可,而同步函数是给这个函数内的所有代码同步.
 * 由于处于同步的代码越少越好,所以最好使用同步代码块儿
 * 
 * * 注意：1.当在一个类中同时存在多个synchronized修饰的代码块儿或函数时，要想安全，就必须让他们后面的对象一致。因为只有同一把锁才能安全。
 * 同步函数的锁：this
 * 2静态同步函数在进内存的时候不会创建对象，但是存在其所属类的字节码文件对象，属于class类型的对象，所以
 * 静态同步函数的锁是其所属类的字节码文件对象
 * 
 * 
 * * 理解synchronized关键字
 * 1、synchronized关键字的作用域有二种： 
1）是某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象
的synchronized方法（如果一个对象有多个synchronized方法，只要一个线程访问了其中的
一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。
这时，不同的对象实例的synchronized方法是不相干扰的。也就是说，其它线程照样可以同时
访问相同类的另一个对象实例中的synchronized方法； 
2）是某个类的范围，synchronized static aStaticMethod{}防止多个线程同时访问
这个类中的synchronized static 方法。它可以对类的所有对象实例起作用。
2、除了方法前用synchronized关键字，synchronized关键字还可以用于方法中的某个区块中，
表示只对这个区块的资源实行互斥访问。用法是: synchronized(this){/区块/}，它的作用域是当前对象；

3、synchronized关键字是不能继承的，也就是说，基类的方法synchronized f(){} 
在继承类中并不自动是synchronized f(){}，而是变成了f(){}。继承类需要你显式的指定
它的某个方法为synchronized方法；
 */
public class Demo5 {
	public static void main(String[] args) {
		//1.创建任务
		SaveMoney saveMoney = new SaveMoney();
		//2.创建两个线程
		Thread t0 = new Thread(saveMoney);
		Thread t1 = new Thread(saveMoney);
		//3.开启线程
		t0.start();
		t1.start();
	}
}
class Bank{
	int sum = 0;
	//同步代码块儿
//	public void addMoney(int money) {
//		synchronized (this) {
//			sum+=money;
//			System.out.println(sum);
//    	}
//	}
	//使用同步函数
	//非静态的同步函数
	//在synchronized后面默认有一个this
//	public synchronized  void addMoney(int money) {
//		sum+=money;
//		System.out.println(sum);
//	}
	//静态的同步函数
	//在synchronized后面默认有一个当前类的字节码文件-----Bank.class
	public synchronized static void addMoney(int money) {
//		sum+=money;
//		System.out.println(sum);
	}
}

class SaveMoney implements Runnable{
	Bank bank = new Bank();
	public void run() {
		for(int i=0;i<3;i++) {
			bank.addMoney(100);
		}
	}
}
