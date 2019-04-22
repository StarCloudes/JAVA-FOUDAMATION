package com.callback.persentation;

public class Worker {     // callback接口类型的引用，用于接收（指向）接口的子类对象——多态
	public void doSomething(Callback callback, String task) {
		
		// 通过doSomething方法告诉员工要做什么
		System.out.println(callback.toString() + "要你: " + task);
		String result = "做完了";
 
		// 当事情做完了我们就通过总经理的phoneCall方法通知总经理结果
		callback.backResult(result);
	}
}
