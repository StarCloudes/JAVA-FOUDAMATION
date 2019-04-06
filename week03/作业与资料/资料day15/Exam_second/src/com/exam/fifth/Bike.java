package com.exam.fifth;

public class Bike implements Vehicle{
	@Override
	public void start() {
		System.out.println("自行车行动");
	}

	@Override
	public void stop() {
		System.out.println("自行车停止");
	}
}
