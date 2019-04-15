package com.classroom.homework18;


public class Demo1 {
	public static void main(String[] args) {
		Thread t0 = new Thread();
		Thread t1 = new Thread(t0);
		t0.start();  //t0 run method
		t1.start();  //t0 run method
		
		new Thread() {//匿名线程对象-匿名内部类直接开启线程
			public void run() {
				System.out.println(Thread.currentThread().getName()+"   haha");
			}
		}.start();
		
		new Thread() {//匿名线程对象调用普通的run方法，这里没有创建新线程
			public void run() {
				System.out.println(Thread.currentThread().getName()+"  hehe");
			}
		}.run();//普通方法，主线程
	}

}



//单例的线程安全
class Single1{
	private static final Single1 single1= new Single1();
	private Single1() {
		
	}
	//因为只有一行代码，不会产生线程安全
	public static Single1 getSingle() {
		return single1;
	}
}
//懒汉式
class Single2{
	private static Single2 single2 = null;
	private Single2() {
		
	}
	public static Single2 getSingle() {
		if(single2 == null) { //减少线程安全判断次数
			synchronized(single2.getClass()) {//使用同步代码块
				if(single2 == null) {        //线程安全问题
					single2 = new Single2();
				}			
			}
		}	
		return single2;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
        return single2;
	}
}