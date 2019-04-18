package com.qianfeng.proxy1;
//代理
public class Agent implements TestInter {
	//引入目标对象
	TestInter person;
	public Agent(TestInter person) {
		super();
		this.person = person;
	}

	@Override
	public void findHouse() {
		System.out.println("扣一半房费做中介费");
	    person.findHouse();
	    System.out.println("哈哈大笑");
	}

}
