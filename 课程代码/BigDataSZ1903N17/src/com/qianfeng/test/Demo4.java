package com.qianfeng.test;
/*
 * 实现四个售票员售票
 * 将四个售票员看做四个线程
 * 数据:一份
 * 
 /* 线程安全问题:
* 分析:4个线程共用了一个数据,出现了-1,-2,-3等错误的数据
* 
* 具体分析:1.共用了一个数据
* 2.共享语句有多条,一个线程使用cpu,没有使用完,cpu被抢走,当再次抢到cpu的时候,直接执行后面的语句,造成了错误的发生.
* 
* 解决:
* 在代码中使用同步代码块儿(同步锁)
* 解释:在某一段任务中,同一时间只允许一个线程执行任务,其他的线程即使抢到了cpu,也无法进入当前的任务区间,只有当当前的线程将任务执行完后,
* 其他的线程才能有资格进入

同步代码块儿的构成:
* synchronized(锁(对象)){
* 	  同步的代码
* }
 

* 对作为锁的对象的要求:1.必须是对象      2.必须保证被多个线程共享
* 可以充当锁的:1.一个普通的对象      2.当前对象的引用--this    3.类的字节码文件
* 
* 同步代码块儿的特点:1.可以保证线程的安全     2.由于每次都要进行判断处理,所以降低了执行效率
* 
* 总结:什么时候使用同步代码块儿
* 1.多个线程共享一个数据
* 2.至少有两个线程
*/
 
public class Demo4 {
	public static void main(String[] args) {
		//0.创建任务对象
		Ticket1 ticket = new Ticket1();
		
		//1.创建四个线程,并且与独立的任务对象关联
		Thread t0 = new Thread(ticket);
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		
		//2.调用start方法,开启线程
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}

//创建任务对象
class Ticket1 implements Runnable{
    int sum = 20;
    boolean flag = true;
  //让Object类型的对象临时充当锁
    Object obj = new Object();
	public void run() {
		//让当前的线程暂时休息一会儿
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (flag) {
			/*
			 * 锁的条件:
			 * 1.锁必须是对象      普通的对象/this/字节码文件
			 * 2.要被所有的线程共享
			 * 
			 * 注意:字节码文件的使用范围太大,一般不建议使用.
			 */
			synchronized (obj) {//让线程互斥---同步代码块儿
				if (sum>0) {
					System.out.println(Thread.currentThread().getName()+"  sum:"+ --sum);
				}else {
					flag = false;
				}
			}
		}
	}
}