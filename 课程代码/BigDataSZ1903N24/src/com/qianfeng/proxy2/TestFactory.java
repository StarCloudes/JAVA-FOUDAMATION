package com.qianfeng.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//创建工厂类,编写一个工厂方法获取代理对象
public class TestFactory {
	public static Object getAgentWithFactory(TestInter person) {
		return Proxy.newProxyInstance(person.getClass().getClassLoader(), new Class[] {TestInter.class}, 
				new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("扣一半房费做中介费");
					Object object = method.invoke(person, args);
					System.out.println("哈哈大笑");
					return object;
				}
			});
	}
}
