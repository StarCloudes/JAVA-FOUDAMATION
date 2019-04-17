package com.qianfeng.reflectDemo;

public class UPan implements USB {

	@Override
	public void startUse() {
		System.out.println("开始使用UPan");

	}

	@Override
	public void endUse() {
		System.out.println("结束使用UPan");

	}

}
