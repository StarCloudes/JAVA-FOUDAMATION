package com.qianfeng.test;

import java.util.ArrayList;

/*
 * 泛型作用于方法上
 */
public class Demo9 {
	public static void main(String[] args) {
		Pig<String > pig = new Pig<>();
		//1.方法上的泛型与类上的泛型保持一致
		pig.show("haha");
		//2.方法上独立使用泛型
		//3.静态方法上使用泛型
	}
}

class Pig<F>{
	//1.方法上的泛型与类上的泛型保持一致
	public void show(F f) {
		System.out.println(f);
	}
	//2.方法上独立使用泛型
	/*
	 * 注意:泛型在使用之前一定要先进行定义
	 * 定义的方式:在当前方法的最前面添加<泛型>
	 * 作用:让方法与方法内的泛型保持一致
	 */
	public <E> void run(E e) {
		ArrayList<E> list = new ArrayList<>();
	}
	//3.静态方法上使用泛型
	/*
	 * 必须独立使用
	 * 方式:在static 后面定义泛型  <泛型> 
	 */
	public static <W> void eat(W f) {
		
	}
}
