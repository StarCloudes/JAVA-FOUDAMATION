package com.qianfeng.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理
//使用InvocationHandler 接口 实现动态代理
public class Agent implements InvocationHandler {
	//引入目标对象
	Object person;
	public Agent(Object person) {
		super();
		this.person = person;
	}


//	@Override
//	public void findHouse() {
//		System.out.println("扣一半房费做中介费");
//	    person.findHouse();
//	    System.out.println("哈哈大笑");
//	}
	
    /*
	 * 接口中的方法
	 * 主要:这个方法在调用接口方法的时候,会被自动调动
	 * 参数一:代理对象的引用
	 * 参数二:目标对象的方法
	 * 参数三:目标对象的方法参数
	 * 
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("扣一半房费做中介费");
		Object object = method.invoke(person, args);
		System.out.println("哈哈大笑");
		return object;
	}

}
