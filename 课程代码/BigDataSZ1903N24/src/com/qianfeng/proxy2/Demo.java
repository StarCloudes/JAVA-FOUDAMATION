package com.qianfeng.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 代理:
 * 动态代理和静态代理
 * 
 * 先讲静态代理:
 * 作用:根据OCP(对扩展开放,对修改关闭)的原则,在不改变原来类的基础上,给这个类增加额外的功能
 * 缺点:代理对象要保证跟目标对象实现同样的接口,在维护的时候两个对象都要维护,
 * 而且代理对象实现的接口是死的,这时如果要给想实现不同功能的多个目标对象添加代理对象的话,要添加很多个类
 * 
 * 实例:冰冰和晨晨通过代理找房
 * 
 * 使用动态代理实现功能
 * 需要已知项
 * 1.目标对象
 * 2.要知道目标对象对应的接口
 * 3.要保证代理对象与目标对象实现相同的接口
 * 4.在代理对象的invoke方法中实现额外的功能和原来目标对象的基本功能
 */
public class Demo {
	public static void main(String[] args) {
		BingBing bing = new BingBing();
		ChenChen chen = new ChenChen();
		
//		Agent agent = new Agent(bing);
//		agent.findHouse();
		
		//调用动态代理的方法实现功能
		/**
		 *动态生成代理对象的方法--通过JDK内置的java.lang.reflect.Proxy动态代理类完成代理对象的创建
		 *参数一:这里代表类加载器,代理类的类加载器要与目标类的类加载器一致,类加载器用来装载内存中的字节码文件
		 *参数二:代理类与目标类实现的接口必须有相同的,即指定给代理类的接口,目标类必须实现了
		 *参数三:代理类的构造方法生成的对象--注意:指定给构造方法的参数要使用Object
		 */
		TestInter agent = (TestInter)Proxy.newProxyInstance(bing.getClass().getClassLoader(), new Class[] {TestInter.class}, new Agent(bing));
		agent.findHouse();
		
		//使用完全的动态代理
		//租房例子讲解
		TestInter agent2 = (TestInter)Proxy.newProxyInstance(bing.getClass().getClassLoader(), new Class[] {TestInter.class}, 
			new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("扣一半房费做中介费");
				Object object = method.invoke(bing, args);
				System.out.println("哈哈大笑");
				return object;
			}
		});
		agent2.findHouse();
		
		
		//使用Agent帮助张三租车
		ZhangSan zhangSan = new ZhangSan();
		TestInter1 agent1 = (TestInter1)Proxy.newProxyInstance(zhangSan.getClass().getClassLoader(), new Class[] {TestInter1.class,TestInter.class}, new Agent(zhangSan));
		agent1.rentCar();
		

		//使用完全代理的
		TestInter1 agent3 = (TestInter1)Proxy.newProxyInstance(zhangSan.getClass().getClassLoader(), new Class[] {TestInter1.class}, 
		   new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("扣一半车费做中介费");
				Object object = method.invoke(zhangSan, args);
				System.out.println("哈哈大笑");
				return object;
			}
		});
		agent3.rentCar();
		
		//使用工厂方法生成的代理对象找房
		TestInter testInter = (TestInter)TestFactory.getAgentWithFactory(bing);
		testInter.findHouse();
		TestInter testInter1 = (TestInter)TestFactory.getAgentWithFactory(chen);
		testInter1.findHouse();
	}
}
