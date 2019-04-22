package com.Demo.persentation;
//总经理出差前要你去办件事情，这件事情通过doSomething告诉你了，事情要是办完了就打总经理的电话phoneCall通知他一声。
//这里的phoneCall我们就称为回调方法（callback）  
//If you call me, I will call back.

//回调的两个基本条件：
//Class A调用Class B中的X方法
//Class B中方法执行的过程中调用Class A中的方法完成回调
//Manager → Worker → Manager

// 该类用来模拟总经理
public class Manager {
	
	//传入一个员工类的对象
	public Manager(Worker worker) {
		// 想让该让员工做什么
		worker.doSomething(this, "整理公司文件");
	}
 
	//当员工做完总经理让他做的事后就通过该方法通知总经理事情结果
	public void phoneCall(String result) {
		System.out.println("文件 " + result);
	}

}
