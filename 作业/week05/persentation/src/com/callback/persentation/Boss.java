package com.callback.persentation;

public class Boss implements Callback{
	String name = "老板";
	
	public Boss(Worker worker) {
		worker.doSomething(this, "准备面试资料");
	}
	
	public void backResult(String result) {
		System.out.println("事情：" + result);
	}

	@Override
	public String toString() {
		return name;
	}		
}
