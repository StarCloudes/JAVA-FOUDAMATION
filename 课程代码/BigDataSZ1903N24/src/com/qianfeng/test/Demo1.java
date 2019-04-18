package com.qianfeng.test;

public class Demo1 {
	/*
	 * 知识总结:
	 * 1.反射:是一个动态的过程-------了解
	 * 	>反射的原理
	 * 	>反射的具体实现
	 * 	>反射的实例
	 * 2.作业
	 * 
	 * 今天的内容:
	 * 1.动态代理----了解
	 * 2.知识总结(全部)
	 * 3.其他
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//实例:想使用Person对象干活儿,利用反射获取对象
		//只要得到Person的字节码文件即可
		//是一个动态的过程
		Class<?>  class1  = Class.forName("com.qianfeng.test.Dog");//这里指定的是Dog的字符串形式,编译的时候不报错,运行时要报错--动态的过程
		Object object = class1.newInstance();
		Person person = (Person)object;
		
		
	}
}

class Dog{
	@Override
	public boolean equals(Object obj) {//多态
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}

class Person{
	
}
