package com.designPattern.code;

//静态代理模式：为其他对象提供一种代理以控制对这个对象的访问
//跟模板设计模式有点类似，但关注点不一样
public class Proxy {
    public static void main(String[] args) {
		Action userAction = new UserAction();
		ActionProxy proxy = new ActionProxy(userAction);
		proxy.doAction();
	}
}

interface Action{
	public void doAction();
}

class ActionProxy implements Action{	
	private Action target;
	public ActionProxy(Action target) {
		this.target = target;
		
	}
	
	public void doAction() { //代理控制业务
		long startTime = System.currentTimeMillis();
		target.doAction(); //执行真正的业务
		long endTime = System.currentTimeMillis();
		System.out.println("Use time: "+ (endTime-startTime));
	}
}

class UserAction implements Action{
	public void doAction() {
		for (int i = 0; i < 100; i++) {
			System.out.println("User starts working...");		
		}		
	}
}