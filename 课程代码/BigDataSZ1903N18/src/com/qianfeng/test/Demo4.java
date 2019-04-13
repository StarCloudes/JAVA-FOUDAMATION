package com.qianfeng.test;
/* 生产者消费者:
* 单生产者单消费者-----会
* 多生产者多消费者-----了解
* 
* 先学习单生产者单消费者
* 需要的线程:两个---一个生产线程一个消费线程
* 需要的任务:两个---一个生产任务一个消费任务
* 需要数据:一份---产品
*/
public class Demo4 {
	public static void main(String[] args) {
		//准备数据
		Product product = new Product();
		//准备任务
		Producer producer = new Producer(product);
		Consumer consumer = new Consumer(product);
		//准备线程
		Thread proThread = new Thread(producer);
		Thread conThread = new Thread(consumer);
		//开启线程
		proThread.start();
		conThread.start();	
	}
}

//创建产品
class Product{
	String name;//产品的名字
	double price;//产品的价格
	int count;//生产的产品数量
	
	//标识
	boolean flag = false;
	
	//准备生产
	public synchronized void setProduce(String name,double price){
		if (flag == true) {
			try {
				wait();//让生产线程等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.name = name;
		this.price = price;
		count++;
		System.out.println(Thread.currentThread().getName()+"   生产了:"+this.name+"   产品的数量:"+this.count+"   价格:"+this.price);
		
		//count++;
		flag = ! flag;
		notify();//唤醒消费线程
	}
	//准备消费
	public  synchronized void getConsume() {
		if (flag == false) {
			try {
				wait();//让消费线程等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		System.out.println(Thread.currentThread().getName()+"   消费了:"+this.name+"   产品的数量:"+this.count+"   价格:"+this.price);
		//唤醒生产线程
		
		flag = ! flag;
		notify();
	}
}
//创建生产任务
class Producer implements Runnable{
	Product product;
	public Producer(Product product) {
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
class Consumer implements Runnable{
	Product product;
	public Consumer(Product product) {
		super();
		this.product = product;
	}
	public void run() {
		while (true) {
			product.getConsume();
		}
	}
}
