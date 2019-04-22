package com.Demo.persentation;

//该类用来模拟员工
public class Worker {
	public void doSomething(Manager manager, String task) {
	
		// 总经理通过doSomething方法告诉员工要做什么
		System.out.println("总经理要你做 " + task);
		String result = "整理好了";
		
		// 当事情做完了我们就通过总经理的phoneCall方法通知总经理结果
		manager.phoneCall(result);
	}
}