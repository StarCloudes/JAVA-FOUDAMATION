package com.qianfeng.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 生产者消费者:

* 研究:研究Lock
 * 比较synchronized和Lock
 * 1.synchronized:从jdk1.0就开始使用的同步方法-称为隐式同步
 * 	synchronized(锁对象){//获取锁      我们将锁还可以称为锁旗舰或者监听器
 * 		同步的代码
 * }//释放锁
 * 2.Lock:从jdk1.5开始使用的同步方法-称为显示同步
 * 
 * 原理:Lock本身是接口,要通过他的子类创建对象干活儿
 *  使用过程:
 *  首先调用lock()方法获取锁
 *    进行同步的代码块儿
 *  使用unlock()方法释放锁
 *  
 *  使用的场景:
 *  当进行多生产者多消费者的功能时,使用Lock,其他的都使用synchronized
 *  
 *  使用效率上:Lock高于synchronized
 */
public class Demo6 {
	public static void main(String[] args) {
		//准备数据
		Product2 product = new Product2();
		//准备任务
		Producer2 producer = new Producer2(product);
		Consumer2 consumer = new Consumer2(product);
		//准备线程
		Thread proThread0 = new Thread(producer);
		Thread proThread1 = new Thread(producer);
		Thread conThread0 = new Thread(consumer);
		Thread conThread1 = new Thread(consumer);
		//开启线程
		proThread0.start();
		proThread1.start();
		conThread0.start();	
		conThread1.start();	
	}
}

//创建产品
class Product2{
	String name;//产品的名字
	double price;//产品的价格
	int count;//生产的产品数量
	
	//标识
	boolean flag = false;
	
	//创建lock对象
	Lock lock = new ReentrantLock();
	//创建控制生产线程的Condition对象
	Condition proCondition = lock.newCondition();
	//创建控制消费线程的Condition对象
	Condition conCondition = lock.newCondition();
	
	//准备生产
	public  void setProduce(String name,double price){
	   try {
			lock.lock();//获取锁
			while (flag == true) {
				try {
					proCondition.await();//让生产线程等待
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.name = name;
			this.price = price;
			System.out.println(Thread.currentThread().getName()+"   生产了:"+this.name+"   产品的数量:"+this.count+"   价格:"+this.price);
			
			count++;
			flag = ! flag;
			//notify();//唤醒消费线程
			//notifyAll();
			conCondition.signal();//这里使用后的效果是唤醒的一定是对方的线程,精准唤醒,比notifyAll提高了程序执行的效率
		}finally {//必须执行的代码
			lock.unlock();//释放锁
		}
		
	}
	//准备消费
	public   void getConsume() {
		try {
			lock.lock();
			while (flag == false) {
				try {
					conCondition.await();//让消费线程等待
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"   消费了:"+this.name+"   产品的数量:"+this.count+"   价格:"+this.price);
			//唤醒生产线程
			flag = ! flag;
			//notify();
			//notifyAll();
			proCondition.signal();
		}finally {
			lock.unlock();
		}
	}
}
//创建生产任务
class Producer2 implements Runnable{
	Product2 product;
	public Producer2(Product2 product) {
		super();
		this.product = product;
	}
	public void run() {
		while (true) {
			product.setProduce("bingbing", 10);
		}
		
	}
}
//创建消费任务
class Consumer2 implements Runnable{
	Product2 product;
	public Consumer2(Product2 product) {
		super();
		this.product = product;
	}
	public void run() {
		while (true) {
			product.getConsume();
		}
	}
}
