package com.exam.fifth;

public class Bus implements Vehicle{
	@Override
	public void start() {
		System.out.println("����������");
	}

	@Override
	public void stop() {
		System.out.println("������ͣ��");
	}
}
