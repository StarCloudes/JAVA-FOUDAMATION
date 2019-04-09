package com.qianfeng.test;
/*
 * 两个线程的通信
 * 
 * 优化
 * 面向对象的精髓:谁的活儿谁干,不是你的活儿不要干
 * 将数据准备的活儿从输入任务输出任务提出来,放入数据类
 * 
 * 
 * 实例:打印机打印----一次输入一次输出
 * 两个线程:输入线程和输出线程
 * 两个任务区:输入任务,输出任务
 * 一份数据
 * 
 * 
 *使用唤醒等待机制---notify()/notifyAll()/wait()
 *wait():让当前的线程变成等待的状态,放入一个池子(线程池),失去了抢cpu的能力,.等待唤醒(锁相当于给当前的线程做了一个标记)
 *
 *notify():让当前的线程从等待状态唤醒,相当于从池子中取出线程.(唤醒的是同一把锁下的任意一个线程)
 *
 *notifyAll():唤醒的是同一把锁下的所有线程
 *
 *明天内容
 *1.单例中的线程安全
 *2.线程的一些注意点
 *3.单生产者单消费者
 *4.多生产者多消费者
 *5.Lock
 *6....
 **/
public class Demo8 {
	public static void main(String[] args) {
		//两个线程:输入线程和输出线程
		//1.准备数据
		Des2 des = new Des2();
		//2.准备两个任务
		Input2 input = new Input2(des);
		Output2 output = new Output2(des);
		//3.准备两个线程
		Thread in = new Thread(input);
		Thread out = new Thread(output);
		//4.开启线程
		in.start();
		out.start();
	}
}
//创建数据类
class Des2{
	String name;
	String sex;
	boolean flag;//控制唤醒和等待状态的切换
	
	//负责输入
	public void setData(String name,String sex) {
		if (flag == true) {//当flag值为true,就让当前的线程处于等待状态
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//当执行这行代码的时候,这里对应的是哪个线程,就操作的是哪个线程
		}
		
		this.name = name;
		this.sex = sex;
		
		flag = !flag;
		
		notify();//唤醒的是通一把锁下的线程,因为现在只有一个输入线程,一个输出线程.所以这里唤醒的是输出线程
		//当线程池中没有被当前的锁标记的线程可唤醒时,我们成为空唤醒,空唤醒不影响程序的执行.
	}
	//负责输出
	public void getData() {
		if (flag == false) {//让输出线程等待
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("姓名:"+name+"    性别:"+sex);
		
		flag = ! flag;
		
		notify();//唤醒的是输入线程
	}
}

//两个任务区:输入任务,输出任务
class Input2 implements Runnable{
	Des2 des = null;
	public Input2(Des2 des) {
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
				
				if (i == 0) {
					des.setData("小特", "男");
				}else {
					des.setData("小三", "女");
				}
				
				i=(i+1)%2;
				
			}
		}
	}
}

class Output2 implements Runnable{
	Des2 des = null;
	public Output2(Des2 des) {
		super();
		this.des = des;
	}
	public void run() {
		while (true) {
			synchronized (des) {
				des.getData();
			}
		}
	}
}

