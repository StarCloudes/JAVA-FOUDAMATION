package com.qianfeng.test;

public class Demo3 {
	public static void main(String[] args) {
		/*
		 * 实例:防暴犬,搜救犬,导盲犬都去工作,中间还有一个导盲驴也要干活儿,导盲犬和导盲驴都要学习导盲技术
		 * 
		 * 抽象类,抽象方法,接口,继承
		 */
	}
}

abstract class 犬{
	public abstract void work();
}

class 防暴犬 extends 犬{
	
	public void work() {
		System.out.println("防爆");
		
	}
}

class 搜救犬 extends 犬{
	
	public void work() {
		System.out.println("搜救");
		
	}
}

interface Inter{
	public void study();
}

class 导盲犬 extends 犬 implements Inter{ 
	@Override
	public void work() {
		System.out.println("导盲");
		
	}
	
	@Override
	public void study() {
		System.out.println("学习导盲技术");
		
	}
}

class 导盲驴  implements Inter{
	@Override
	public void study() {
		System.out.println("学习导盲技术");
		
	}
}
