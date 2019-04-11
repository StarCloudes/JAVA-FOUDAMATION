package com.qianfeng.test;
/*
 * 单例中的线程安全
 */
//饿汉式
class SingleInstance1{
	private static final SingleInstance1 singleInstance1 = new SingleInstance1();
	private SingleInstance1() {
	}
	//因为这里只有一行代码,所以不会产生线程安全问题.
	public static SingleInstance1 getInstance() {
		return singleInstance1;
	}
}
//懒汉式
class SingleInstance2{
	private static  SingleInstance2 singleInstance2 = null;
	private SingleInstance2() {
	}
	public static SingleInstance2 getInstance() {
		if (singleInstance2 == null) {//尽量减少线程安全代码的判断次数,提高效率
			synchronized (SingleInstance2.class) {//使用同步代码块儿实现了线程安全
				if (singleInstance2 == null) {
					singleInstance2 = new SingleInstance2();
				}
			}
		}
		return singleInstance2;
	}
	
	//将克隆方法重写
	protected Object clone() throws CloneNotSupportedException {
		return singleInstance2;
	}
}
public class Demo2 {
	//测试
	public static void main(String[] args) {
		
	}
}

class Test implements Runnable{
	public void run() {
		SingleInstance1 singleInstance1 = SingleInstance1.getInstance();
	}
}
