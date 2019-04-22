package com.callback.persentation;

//让总经理实现回调函数的接口
public class Manager implements Callback{
	String name = "总经理";
	
	public Manager(Worker worker) {
		// 想让该让员工做什么
		worker.doSomething(this, "整理公司文件");
	}
	
	public void backResult(String result) {
		System.out.println("事情：" + result);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
