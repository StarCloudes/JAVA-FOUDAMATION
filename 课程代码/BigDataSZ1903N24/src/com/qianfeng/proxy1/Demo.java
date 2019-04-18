package com.qianfeng.proxy1;
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
 */
public class Demo {
	public static void main(String[] args) {
		BingBing bing = new BingBing();
		ChenChen chen = new ChenChen();
		
		Agent agent = new Agent(chen);
		agent.findHouse();
	}
}
