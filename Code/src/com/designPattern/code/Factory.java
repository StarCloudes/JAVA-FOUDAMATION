package com.designPattern.code;

import jdk.internal.dynalink.beans.StaticClass;

//工厂模式 由工厂对象决定创建哪一种产品类的实例
//降低使用者和被使用者的依赖

public class Factory {
	
	public static void main(String[] args) {
		Product phone = ProdauctFactory.getProduct("phone");
		if(phone != null) {
			phone.work();
		}
	}

}
class ProdauctFactory{
	public static Product getProduct(String name) {
		if (name.equals("phone")) {
			return new Phone();
		}else if(name.equals("computer")) {
			return new Computer();
		}else {
			return null;	
		}		
	}
}

interface Product{
	public void work();
}

class Phone implements Product{
	@Override
	public void work() {
		System.out.println("Phone is working...");
	}
}

class Computer implements Product{
	@Override
	public void work() {
		System.out.println("Computer is working...");
	}
}
