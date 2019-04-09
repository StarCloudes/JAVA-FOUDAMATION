package com.qianfeng.test;
/*
 * 两个线程的通信
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
 **/
 
public class Demo7 {
	public static void main(String[] args) {
		//1.创建了数据对象
		Des1 des = new Des1();
		//2.将数据交给了两个任务
		Input1 input = new Input1(des);
		Output1 output  = new Output1(des);
		//3.创建对象的线程
		Thread inThread = new Thread(input);
		Thread outThread = new Thread(output);
		//4.启动线程
		inThread.start();
		outThread.start();
	}
}
//数据类
class Des1{
	String name;
	String sex;
	boolean flag;//用于唤醒和等待之间的切换
}

//输入任务
class Input1 implements Runnable{
	Des1 des;
	public Input1(Des1 des) {
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
				if (des.flag == true) {//如果是true,让当前的线程处于等待状态
					try {
						des.wait();//当执行这行代码的时候,这里对应的是哪个线程,就操作的是哪个线程
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (i==0) {
					des.name = "小特";
					des.sex = "男";
				}else {
					des.name = "小三";
					des.sex = "女";
				}
				i=(i+1)%2;
				des.flag = !des.flag;
				
				des.notify();//唤醒的是通一把锁下的线程,因为现在只有一个输入线程,一个输出线程.所以这里唤醒的是输出线程
				//当线程池中没有被当前的锁标记的线程可唤醒时,我们成为空唤醒,空唤醒不影响程序的执行.
			}
		}
	}
}
//输出任务
class Output1 implements Runnable{
	Des1 des;
	public Output1(Des1 des) {
		super();
		this.des = des;
	}
	public void run() {
		while (true) {
			synchronized (des) {
				if (des.flag == false) {//让输出线程等待
					try {
						des.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("姓名:"+des.name+"    性别:"+des.sex);
				
				des.flag = !des.flag;
				des.notify();
			}
		}
	}
}
